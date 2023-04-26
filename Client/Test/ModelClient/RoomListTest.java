package ModelClient;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class RoomListTest
{
  private RoomList list;

  @BeforeEach public void setUp(){
    this.list = new RoomList();
  }

  /*
  Z = add a room in a empty list;
  O= add a room in a one element list;
  M = add one or more rooms in a list with elements;
  B = there is no upper limit for this room list;
  E = add a room with null values should throw an exception;
   */

  @Test public void addRoomInEmpty(){
    Room room = new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3");
    list.addRoom(room);
    assertEquals(room,list.getRoomAtIndex(0));
  }
  @Test public void addRoomInOneElementList(){
    list.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2"));
    Room room = new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3");
    list.addRoom(room);
    assertEquals(room,list.getRoomAtIndex(1));
  }
  @Test public void addRoomInListWithMany(){
    list.addRoom(new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3"));
    list.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2"));
    list.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1"));
    Room room = new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3");
    list.addRoom(room);
    assertEquals(room,list.getRoomAtIndex(3));
  }
  @Test public void addRoomWithNullValues(){
    assertThrows(IllegalArgumentException.class,()->list.addRoom
        (new Room("Room next Lovbjerg.",null, "123 Main St", "200", "3")));
  }


}