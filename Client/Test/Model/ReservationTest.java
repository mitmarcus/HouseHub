package Model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest
{

  @BeforeEach void setUp()
  {
  }

  /*
  Constructor
  Should throw an exception if one of the parameters is null
   */

  @Test public void constructor(){
    assertThrows(IllegalArgumentException.class,()->new Reservation(null,null,null,null));
  }
  /*
  getStartDate()
  getEndDate()
  getRoom()

  this methods are already being tested in the constructor because its not legal to create a reservation with null values
   */


}