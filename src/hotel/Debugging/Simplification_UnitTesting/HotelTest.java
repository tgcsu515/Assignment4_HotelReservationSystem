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
        guest = new Guest("Gurpreet Gill", "Melbourne", 041234567);
        room = new Room(301, RoomType.TWIN_SHARE);
        arrivalDate = new Date();
        stayLength = 7;
        noOfOccupants = 3;
        creditCard = new CreditCard(CreditCardType.VISA, 123123123, 123);
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
        int roomId = 301;
	hotel.checkout(roomId);
	}
}