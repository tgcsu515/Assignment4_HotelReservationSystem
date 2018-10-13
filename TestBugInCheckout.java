package JUnit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.hotel.credit.CreditCard;
import src.hotel.credit.CreditCardType;
import src.hotel.entities.Booking;
import src.hotel.entities.Guest;
import src.hotel.entities.Hotel;
import src.hotel.entities.Room;
import src.hotel.entities.RoomType;
import src.hotel.entities.ServiceCharge;
import src.hotel.entities.ServiceType;




public class TestBugInCheckout 
    {
	Hotel hotel;
	Date date;
	int stayLength=2;
        int occupants=2;
	Room room;
	Guest guest;
	CreditCard card;
	

	@Before 
	

    public void setUp() throws Exception
      {

		// setting up all the required variables and objects in the hotel Application

		hotel = new Hotel();        // create the object of the  Hotel class
		hotel.addRoom(RoomType.SINGLE, 101);     // add the  room type and room number

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");//  date format

		date = format.parse("25-10-2018");    // arrival date in the hotel

		room = new Room(101,RoomType.SINGLE);    // create the new object of the room class
    
                String name = " Amandeep Kaur";      // craete the  name 

                int phoneNumber = 0470249956 ;      //create the phone number

                
                String address = "St Albans";        //create the  address variable

		guest = new Guest(name, phoneNumber, address);  // create the  object  of  Guest class

		card = new CreditCard(CreditCardType.VISA, 1, 123); // create the object of CreditCard class

		
                long confirmationNumber =hotel.book(room, stayLength, guest, date, occupants, card); // get the confirmation number

		hotel.checkin(confirmationNumber);      // checkin by passing confirmationNumber
		

	}

	@After 

    public void tearDown() throws Exception 
           {

		card = null;
                guest = null;
		room = null;
                hotel = null;

	}

    
	testCheckout() method to check that customer is checked out  
        @Test
        public void testCheckout() 
        { 

            int roomNumber = 101;
    	    hotel.checkout(roomNumber);      // call the  checkout method
    	}

      //Method to check whether the booking for checkout room is till available in record.
       
        @Test
        public void testFindActiveBookingByRoomId() {
            
            int roomNumber = 101;     // initialize the room number

            hotel.checkout(roomNumber);  // calling the  checkout method of hotel to confirm the  checkout 

            Booking expectedOutput = null;     // booking has to be null after checkout

            Booking actualOutput = hotel.findActiveBookingByRoomId(roomNumber);  //  check the booking available in record 

            assertEquals(expectedOutput, actualOutput);   // compare  the expected and actual output
        }

	}
	

	
	





   



