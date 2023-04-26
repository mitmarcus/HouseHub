package ModelClient;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RoomListTest {
    private RoomList list;

    @BeforeEach
    public void setUp() {
        this.list = new RoomList();
    }

  /*
  Z = add a room in a empty list;
  O= add a room in a one element list;
  M = add one or more rooms in a list with elements;
  B = there is no upper limit for this room list;
  E = add a room with null values should throw an exception;
   */

    /*
  Z = can not remove zero rooms;
  O = remove one room from the list;
  M = remove 3 rooms from;
  B = remove a room from an empty list throws exception;
  E = already handled in B;
   */

    @Test public void removeRoom(){
        Room room = new Room("bb","6.66","Horsens", "123", "3");
        list.addRoom(room);
        assertDoesNotThrow(()->list.removeRoom(room));
    }
    @Test public void removeManyRooms(){
        Room room = new Room("bb","6.66","Horsens", "143", "3");
        Room room1 = new Room("bb","6.66","Horsens", "123", "3");
        Room room2 = new Room("bb","6.66","Horsens", "133", "3");
        list.addRoom(room);
        list.addRoom(room1);
        list.addRoom(room2);
        assertDoesNotThrow(()->list.removeRoom(room));
        assertDoesNotThrow(()->list.removeRoom(room1));
        assertDoesNotThrow(()->list.removeRoom(room2));
    }
    @Test public void removeFromEmptyList(){
        Room room = new Room("bb","6.66","Horsens", "143", "3");
        list.addRoom(room);
        list.removeRoom(room);
        assertThrows(IllegalStateException.class, () -> list.removeRoom(new Room("bb","6.66","Horsens", "143", "3")));
    }
    @Test public void removeException(){
        // already handled in B
    }

}