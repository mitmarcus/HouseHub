package Model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest
{

  @BeforeEach void setUp()
  {

  }

  /*
      Constructor
  Z - Create a room with zero argument constructor should trow an exception;
  O - Create a room with one argument constructor should trow an exception;
  M - Create a room with all arguments constructor should  not trow an exception;
  B - Already tested before.
  E - Already tested before.
   */

  @Test void createWithZero(){

    assertThrows(
        NullPointerException.class,()->new Room(null, null ,null,null,null, null,false));
  }
  @Test void createWithOne(){
    assertThrows(
        NullPointerException.class,()->new Room(null, "300" ,null,null,null, null,false));
  }
  @Test void createWithMany(){
    assertDoesNotThrow(
        ()->new Room(new User("Ricardo","Fernandes","rfernandes","1233212",
            "12345678"),"bb","6.66","Horsens", "143", "3",false));
  }

  /*
      getAnnouncement()
      getPrice()
      getAddress()
      getSize()
      this method are already covered in the constructor since is not possible to create a room with null parameters
   */

  /*
  setAddress()
  setSize()
  setBedrooms()
  setPrice()

  this method should throw an exception if the parameter for the method is null or "";
   */
  @Test void setAddress(){
    Room room = new Room(new User("Ricardo","Fernandes","rfernandes","1233212",
        "12345678"),"bb","6.66","Horsens", "143", "3",false);
    assertThrows(IllegalArgumentException.class,()->room.setAddress(""));
    assertThrows(IllegalArgumentException.class,()->room.setAddress(null));
  }
  @Test void setSize(){
    Room room = new Room(new User("Ricardo","Fernandes","rfernandes","1233212",
        "12345678"),"bb","6.66","Horsens", "143", "3",false);
    assertThrows(IllegalArgumentException.class,()->room.setSize(""));
    assertThrows(IllegalArgumentException.class,()->room.setSize(null));
  }
  @Test void setBedrooms(){
    Room room = new Room(new User("Ricardo","Fernandes","rfernandes","1233212",
        "12345678"),"bb","6.66","Horsens", "143", "3",false);
    assertThrows(IllegalArgumentException.class,()->room.setBedrooms(""));
    assertThrows(IllegalArgumentException.class,()->room.setBedrooms(null));
  }
  @Test void setPrice(){
    Room room = new Room(new User("Ricardo","Fernandes","rfernandes","1233212",
        "12345678"),"bb","6.66","Horsens", "143", "3",false);
    assertThrows(IllegalArgumentException.class,()->room.setPrice(""));
    assertThrows(IllegalArgumentException.class,()->room.setPrice(null));
  }

  /*
  equals()
  this method should throw an exception if the object in parameter is null
   */
  @Test void equals(){
    Room room = new Room(new User("Ricardo","Fernandes","rfernandes","1233212",
        "12345678"),"bb","6.66","Horsens", "143", "3",false);
    assertThrows(NullPointerException.class,()-> room.equals(null));
  }
}