

import static org.junit.Assert.*;


import java.text.SimpleDateFormat;
import java.util.Date;

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




public class BugInServiceCharged 
       
{
	Hotel hotel;
	Date date;
	int stayLength=2;
	Room room;
	Guest guest;
	CreditCard card;
	int occupants=2;

	@Before 
	

    public void setUp() throws Exception {

		
		hotel = new Hotel();      // create the object of the  Hotel class

		hotel.addRoom(RoomType.SINGLE, 101);     // add the  room to hotel

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");    //  date format

		date = format.parse("25-10-2018");     // initialize the  arrival date

		room = new Room(102,RoomType.SINGLE);    // create the object of  the Room class

               
                int phoneNumber = 0470249956;     //initialize the  phone number variable

                String name =" Amandeep Kaur";      // initialize name variable

                 String address = "St Albans";    //initialize the address 

		guest = new Guest(name, phoneNumber, address);      // initialize the  object of the  Guest class

		card = new CreditCard(CreditCardType.VISA, 1, 123);    // initialize the  object of CreditCard class

		long confirmationNumber =hotel.book(room, guest, date, stayLength, occupants, card); // gererate the confirmation number by calling the book method
    
		hotel.checkin(confirmationNumber);        // checkin by passing  the confirmationNumber
		}

	

	@After 

    public void tearDown() throws Exception {

		card = null;
                guest = null;
                room = null;
                hotel = null;

	}

	// Method to test the charges  service charge 

	public void testServiceChargedMethod() throws Exception { 
		   
		double charge= 150;

		Booking booking= new Booking(guest,room,date,stayLength,occupants,card);   //create the  booking object with passing objects as parameters

		booking.addServiceCharge(ServiceType.RESTAURANT, charge);// calling addServiceCharge method of booking class by passing service type and cost to that service as parameters
		
                List<ServiceCharge> charges = booking.getCharges();     // create the  list to add charges of type ServiceCharge class
                
                for(ServiceCharge servicecharge: charges)
               
                {
                       assertEquals(charge, servicecharge.getCost(),50); // compare expected and actual value by  calling getCost method 
                }
	}

}

	
	





   



