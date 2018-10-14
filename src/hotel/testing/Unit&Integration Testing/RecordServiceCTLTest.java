package hotel.service;

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

/*
The following RecordServiceCTLTest class implements test method to demonstrate and reproduce the buggy behavior of the reported second bug.
The setUp() method creates the testing environment of RecordServiceCTLTest class.
 */
public class RecordServiceCTLTest {
	
	//Define all the require variables
    Booking currentBooking;
    Guest newGuest;
    Room newRoom;
    Date currentDate;
    int stayLength;
    int noOfOccupants;
    int roomId;
    CreditCard newCreditCard;
    private static Hotel currentHotel;
    RecordServiceCTL recordServiceCTLObj;
	
	@Before
    public void setUp() throws Exception {
        //Create the testing backgroud
        newGuest = new Guest("Jack Peterson", "Melbourne", 04234634); //Create a new Guest 
        roomId = 301; //Set value for room Id
        newRoom = new Room(roomId, RoomType.SINGLE); //Create a new Room
        Date arrivalDate = new Date();
        stayLength = 2;
        noOfOccupants = 1;
        newCreditCard = new CreditCard(CreditCardType.VISA, 25738, 572); //Create a new Credit Card
        //Create an instance of Booking class using the above parameters
        currentBooking = new Booking(newGuest, newRoom, arrivalDate, stayLength, noOfOccupants, newCreditCard);
        currentHotel = HotelHelper.loadHotel(); //Create a new Hotel instance
        recordServiceCTLObj = new RecordServiceCTL(currentHotel); //Create a new RecordServiceCTL object
    }
	
	@After
    public void tearDown() {
        //Set all the created instances to null
        newGuest = null;
        newRoom = null;
        newCreditCard = null;
        currentBooking = null;
        currentHotel = null;
        recordServiceCTLObj = null;
    }
	
	/* Test of testBuggyBehaviorOfReportedSecondBug method of RecordServiceCTL class */
    @Test
    public void testBuggyBehaviorOfReportedSecondBug() {
        //Define the actual result
        String actualResult;
        //Define the expected result
        String expectedResult = "No active booking for room id: 301";
        currentHotel.checkout(roomId); //Check out the guest from the room
        currentBooking = currentHotel.findActiveBookingByRoomId(roomId); //Get the active booking using the room Id
        if (currentBooking == null) {
            //Get the actual result if the current booking is null after the guest has checked out 
            actualResult = String.format("No active booking for room id: %d", roomId);
        } else {
            //Get the actual result if the current booking is not null even after guest has checked out
            actualResult = String.format("There is an active booking for room id: %d", roomId);
        }
        assertEquals(expectedResult, actualResult);  //Compare the  expected result with the actual result      
    }
	
}