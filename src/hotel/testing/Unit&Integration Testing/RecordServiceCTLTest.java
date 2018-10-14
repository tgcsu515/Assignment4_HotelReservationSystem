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
}