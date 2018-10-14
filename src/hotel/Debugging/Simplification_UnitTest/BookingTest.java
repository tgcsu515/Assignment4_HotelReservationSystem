/*
Test has been performed to fix the reported bug "Add Charges for Extra services".
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

    //Define all the required variables
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
        guest = new Guest("Arashdeep Kaur", "Mel", 0416241254);
        room = new Room(707, RoomType.TWIN_SHARE);
        Date arrivalDate = new Date();
        stayLength = 4;
        noOfOccupants = 2;
        creditCard = new CreditCard(CreditCardType.VISA, 702245701, 987);
        //Create an instance of Booking class using the parameters
        booking = new Booking(guest, room, arrivalDate, stayLength, noOfOccupants, creditCard);
    }
	
	
    @After
    public void tearDown() {
        booking = null; //Setting booking object to null
    }
	
	/*Test of addServiceCharge method of Booking class*/
    @Test
    public void testAddServiceCharge() {
        List<ServiceCharge> charges = null;
        ServiceCharge currentServiceCharge = null;
        String actualResult = "";

        String expectedResult = "Service Type is RESTAURANT and Service Charge is 535.0"; //Define expected result
        booking.setState();
        booking.addServiceCharge(ServiceType.RESTAURANT, 535); //Call the method
        charges = booking.getCharges(); //Get the charges list
        currentServiceCharge = charges.get(0); //Get the first item from the list
        actualResult = "Service Type is " + currentServiceCharge.getType() + " and Service Charge is " + currentServiceCharge.getCost();
        assertEquals(expectedResult, actualResult); //Compare the  expected result with the actual result
    }
}