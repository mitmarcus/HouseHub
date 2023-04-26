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
  O = add a room that aleady exist in the list should throw exception
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
  @Test public void addARoomThatAlreadyExist(){
    list.addRoom(new Room("Room next Lovbjergasdasdasd.","$500", "123 Main St", "200", "3"));
    Room room =new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2");
    Room room2 = new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2");
    list.addRoom(room);
    assertThrows(IllegalArgumentException.class,()->list.addRoom(room2));
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

    /* GET ROOM AT INDEX
  Z = get a room from index zero;
  O = get a room from index 1 ;
  M = add 2 rooms and get them ;
  B = get a room from index -1;
  E = already handled in B;
   */

    @Test public void getRoomIndexZero(){
        Room room = new Room("bb","6.66","Horsens", "143", "3");
        list.addRoom(room);
        assertDoesNotThrow(()-> list.getRoomAtIndex(0));
    }
    @Test public void getRoomIndexOne(){
        Room room = new Room("bb","6.66","Horsens", "143", "3");
        Room room1 = new Room("bb","6.16","Horsens", "143", "3");
        list.addRoom(room);
        list.addRoom(room1);
        assertDoesNotThrow(()-> list.getRoomAtIndex(1));
    }
    @Test public void getManyRooms(){
        Room room = new Room("bb","6.66","Horsens", "143", "3");
        Room room1 = new Room("bb","6.16","Horsens", "143", "3");
        list.addRoom(room);
        list.addRoom(room1);
        assertDoesNotThrow(()-> list.getRoomAtIndex(0));
        assertDoesNotThrow(()-> list.getRoomAtIndex(1));
    }
    @Test public void getRoomFromInvalidIndex(){
        Room room = new Room("bb","6.66","Horsens", "143", "3");
        Room room1 = new Room("bb","6.16","Horsens", "143", "3");
        list.addRoom(room);
        list.addRoom(room1);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> list.getRoomAtIndex(-1));
    }
    @Test public void getRoomException(){
        // already handled in B
    }
    /*
    Z - return an empty list should throw an exception
    O - return an list with one element
    M - return a list with many elements
    B - already done in Z
    E - already done is Z
     */

    @Test public void returnEmptyList(){
      assertThrows(IllegalStateException.class, ()->list.getAllRooms());
    }
    @Test public void returnListWithOne(){
      Room room = new Room("bb","6.66","Horsens", "143", "3");
      list.addRoom(room);
      assertDoesNotThrow(()->list.getAllRooms());
    }
    @Test public void returnListWithMany(){
      list.addRoom(new Room("Room next Lovbjerg.","$500", "123 Main St", "200", "3"));
      list.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2"));
      list.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1"));
      assertDoesNotThrow(()-> list.getAllRooms());
    }



}