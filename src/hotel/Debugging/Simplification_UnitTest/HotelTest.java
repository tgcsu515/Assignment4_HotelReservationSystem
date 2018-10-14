/*
This test is performed to check the second reported bug.
*/
package hotel.entities;
import hotel.credit.CreditCard;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import hotel.credit.CreditCardType;

public class HotelTest {
     //Define all the require variables
    Hotel hotel;
    Booking booking;
    Guest guest;
    Room room;
    Date arrivalDate;
    int stayLength;
    int noOfOccupants;
    CreditCard creditCard;
    long bookingNumber;
    
    @Before
    public void setUp() {
         //Create the testing backgroud
        hotel = new Hotel();
        guest = new Guest("Arashdeep Kaur", "Mel", 0416241254);
        room = new Room(707, RoomType.TWIN_SHARE);
        arrivalDate = new Date();
        stayLength = 4;
        noOfOccupants = 2;
        creditCard = new CreditCard(CreditCardType.VISA, 702245701, 987);
        bookingNumber = hotel.book(room, guest, arrivalDate, stayLength, noOfOccupants, creditCard); //Generate confirmation number.
        hotel.checkin(bookingNumber); //Checkin by using confirmation number.
    }
    
    @After
    public void tearDown() {
        hotel = null;
    }
    //Test the checkout method
    @Test
    public void testCheckout() {
        int roomId = 707;
	hotel.checkout(roomId);
	}
	// check is record still showing after checkout.
    @Test
    public void testFindActiveBookingByRoomId() {
        
        int roomId = 707;
        hotel.checkout(roomId);
        Booking expectedExceptionResult = null;
        Booking actualExceptionresult = hotel.findActiveBookingByRoomId(roomId);
        assertEquals(expectedExceptionResult, actualExceptionresult);
    }
}