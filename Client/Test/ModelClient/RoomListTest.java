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

  @Test public void addRoomInEmpty
}