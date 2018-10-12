/*
This test is performed to test the Add other services reported bug.
*/
package hotel.entities;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingTest {

    //Define all the require variables
    Booking booking;
    Guest guest;
    Room room;
    Date currentDate;
    int stayLength;
    int noOfOccupants;
    CreditCard creditCard;

    @Before
    public void setUp() {
        //Create the testing backgroud
        guest = new Guest("Gurpreet Gill", "Melbourne", 041234567);
        room = new Room(302, RoomType.TWIN_SHARE);
        Date arrivalDate = new Date();
        stayLength = 7;
        noOfOccupants = 3;
        creditCard = new CreditCard(CreditCardType.VISA, 123123123, 123);
        //Create an instance of Booking class using the above parameters
        booking = new Booking(guest, room, arrivalDate, stayLength, noOfOccupants, creditCard);
    }
	
	
    @After
    public void tearDown() {
        booking = null; //Set booking object to null
    }
	

}