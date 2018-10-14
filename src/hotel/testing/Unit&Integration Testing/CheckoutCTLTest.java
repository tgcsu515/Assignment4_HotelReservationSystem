package hotel.checkout;

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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
The following CheckoutCTLTest class implements test method to demonstrate and reproduce the buggy behavior of the reported first bug.
The setUp() method creates the testing environment of CheckoutCTLTest class.
 */
public class CheckoutCTLTest {
	
	//Define all the require variables
    Booking bookingObj;
    Guest newGuest;
    Room newRoom;
    Date currentDate;
    int stayLength;
    int noOfOccupants;
    CreditCard newCreditCard;
    private static Hotel hotel;
    CheckoutCTL checkOutCTLObj;
	
	@Before
    public void setUp() throws Exception {
        //Create the testing backgroud
        newGuest = new Guest("Peter Dawson", "Melbourne", 042345224); //Create a new Guest 
        newRoom = new Room(1102, RoomType.SINGLE); //Create a new Room
        Date arrivalDate = new Date();
        stayLength = 2;
        noOfOccupants = 1;
        newCreditCard = new CreditCard(CreditCardType.VISA, 234688654, 248); //Create a new Credit Card
        //Create an instance of Booking class using the above parameters
        bookingObj = new Booking(newGuest, newRoom, arrivalDate, stayLength, noOfOccupants, newCreditCard);
        hotel = HotelHelper.loadHotel(); //Create a new Hotel instance
        checkOutCTLObj = new CheckoutCTL(hotel); //Create a new CheckoutCTL object
    }
	
	    @After
    public void tearDown() {
        //Set all the created instances to null
        newGuest = null;
        newRoom = null;
        newCreditCard = null;
        bookingObj = null;
        hotel = null;
        checkOutCTLObj = null;
    }
	
	/* Test of testBuggyBehaviorOfReportedFirstBug() method of CheckoutCTL class */
    @Test
    public void testBuggyBehaviorOfReportedFirstBug() {
        //Define expected result
        String expectedResult = "    Restaurant  :     $200.00\n" + "    Room Service:     $150.00\n" + "Total: $350.00\n";
        bookingObj.addServiceCharge(ServiceType.RESTAURANT, 200); //Add a new Service Charge to the booking
        bookingObj.addServiceCharge(ServiceType.ROOM_SERVICE, 150);//Add another new Service Charge to the booking
        String actualResult = checkOutCTLObj.getAllServiceChargesRecorded(bookingObj); //Get the actual result
        assertEquals(expectedResult, actualResult);  //Compare the  expected result with the actual result
    }
	
}