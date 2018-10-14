/**Developed by Kanchan Bala,  Course : MIT, Subject: Professional Programming Practices, Team: TeamGenius
 * Student ID: 11635336
 * Assessment #4, (Debugging)
 * @version 9.0.4(build 9.0.4+ 11)
 *
 * In this program, I have created a setup and write a code to test the checkoutCTL, in which the first bug have been reported. This testing 
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
import hotel.entities.ServiceType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CheckoutCTLTest {
    
	//created objects of the classes
    Hotel hotelObj;
    CheckoutCTL checkoutCTLObj;
    Guest guestObj;
    Room roomObj;
    Booking bookingObj;
    CreditCard creditCardObj;
       
    @Before
    public void setUp() throws Exception {//created setup, in which the parameters have been passed for the created objects
        
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
        guestObj = null;//initializing the variables as null
        roomObj = null;
        creditCardObj = null;
        bookingObj = null;
        hotelObj = null;
        checkoutCTLObj = null;
    }

     
    @Test
    public void testFirstReportedBug() {//testing first bug
        String expectedResult = "BAR_FRIDGE : $200.00" + "Restaurant : $200.00" +"Room Service : $200.00" +"Total : $600.00";//defining expected result
        bookingObj.addServiceCharge(ServiceType.BAR_FRIDGE, 200);//passing the parametersto the addServiceCharge
        bookingObj.addServiceCharge(ServiceType.RESTAURANT, 200);
        bookingObj.addServiceCharge(ServiceType.ROOM_SERVICE, 200);
        String actualResult = checkoutCTLObj.getServiceChargesRecorded(bookingObj);//getting actual result
        assertEquals(expectedResult, actualResult);//comparing expected and actual results
    }
}
