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
}