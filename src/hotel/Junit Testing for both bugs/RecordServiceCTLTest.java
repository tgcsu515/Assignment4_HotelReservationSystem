

import hotel.HotelHelper;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

 
public class RecordServiceCTLTest {
    
    RecordServiceCTL recordServiceCTLObj;
    Hotel hotelObj;
    Booking bookingObj;
    Guest guestObj;
    Room roomObj;
    CreditCard creditCardObj;
    int roomId = 301;
    
    
    @Before
    public void setUp() throws Exception {
        guestObj = new Guest("Kanchan", "Melbourne", 043132232);
        roomObj = new Room(4890, RoomType.DOUBLE);
        Date arrivalDate = new Date();//creating object of date
        int stayLength = 3;//defining and initialize staylength
        int noOfOccupants = 2;//defining and initialize noOfOccupants
        creditCardObj = new CreditCard(CreditCardType.VISA, 234567788, 123);//passing values to the parameters of creditcard
        bookingObj = new Booking(guestObj, roomObj, arrivalDate, stayLength, noOfOccupants, creditCardObj);//Create an instance of Booking class using the above parameters
        hotelObj = HotelHelper.loadHotel();
        recordServiceCTLObj = new RecordServiceCTL(hotelObj);
    }
    
    @After
    public void tearDown() {
        guestObj = null;
        roomObj = null;
        creditCardObj = null;
        bookingObj = null;
        hotelObj = null;
        recordServiceCTLObj = null;
    }

    
    @Test
    public void testSecondReportedBug() {
        String actualResult = "";
        String expectedResult = "No active booking for room id: 301";
        hotelObj.checkout(roomId);
        bookingObj = hotelObj.findActiveBookingByRoomId(roomId);
        if(bookingObj == null){
            actualResult = String.format("No active booking for room id: %d", roomId);
        }
        else{
            actualResult = String.format("Room Id already exist : %d", roomId);
        }
        assertEquals(expectedResult, actualResult);
    }  
}
