package ModelClient;

import java.util.ArrayList;

public interface ModelClient
{
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();

}
