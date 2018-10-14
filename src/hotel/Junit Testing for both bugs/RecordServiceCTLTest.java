/**Developed by Kanchan Bala,  Course : MIT, Subject: Professional Programming Practices, Team: TeamGenius
 * Student ID: 11635336
 * Assessment #4, (Debugging)
 * @version 9.0.4(build 9.0.4+ 11)
 *
 * In this program, I have created a setup and write a code to test the recordServiceCTL, in which the first bug have been reported. This testing 
 * has been failed due to the bug.
 */

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
    
	//created object of the classes which are required for the system
    RecordServiceCTL recordServiceCTLObj;
    Hotel hotelObj;
    Booking bookingObj;
    Guest guestObj;
    Room roomObj;
    CreditCard creditCardObj;
    int roomId = 301;
    
    
    @Before
    public void setUp() throws Exception {//created setup for the testing by passing the parameters
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
        guestObj = null;//initializing the objects with null value
        roomObj = null;
        creditCardObj = null;
        bookingObj = null;
        hotelObj = null;
        recordServiceCTLObj = null;
    }

    
    @Test
    public void testSecondReportedBug() {
        String actualResult = "";//defining actual result
        String expectedResult = "No active booking for room id: 301";//defining expected result
        hotelObj.checkout(roomId);
        bookingObj = hotelObj.findActiveBookingByRoomId(roomId);
        if(bookingObj == null){
            actualResult = String.format("No active booking for room id: %d", roomId);
        }
        else{
            actualResult = String.format("Room Id already exist : %d", roomId);
        }
        assertEquals(expectedResult, actualResult);//comparing the expected and actual results
    }  
}
