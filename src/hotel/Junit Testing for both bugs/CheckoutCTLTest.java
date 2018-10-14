import hotel.HotelHelper;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CheckoutCTLTest {
    
    Hotel hotelObj;
    CheckoutCTL checkoutCTLObj;
    Guest guestObj;
    Room roomObj;
    Booking bookingObj;
    CreditCard creditCardObj;
       
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
        checkoutCTLObj = new CheckoutCTL(hotelObj);
    }
    
    @After
    public void tearDown() {
        guestObj = null;
        roomObj = null;
        creditCardObj = null;
        bookingObj = null;
        hotelObj = null;
        checkoutCTLObj = null;
    }

     
    @Test
    public void testFirstReportedBug() {
        String expectedResult = "BAR_FRIDGE : $200.00" + "Restaurant : $200.00" +"Room Service : $200.00" +"Total : $600.00";
        bookingObj.addServiceCharge(ServiceType.BAR_FRIDGE, 200);
        bookingObj.addServiceCharge(ServiceType.RESTAURANT, 200);
        bookingObj.addServiceCharge(ServiceType.ROOM_SERVICE, 200);
        String actualResult = checkoutCTLObj.getServiceChargesRecorded(bookingObj);
        assertEquals(expectedResult, actualResult);
    }
}
