package ModelServer;

import java.util.ArrayList;
import java.util.Date;

public interface ModelServer
{
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();
  void addReservation(Date startDate, Date endDate, Room room);
  void removeReservation(Date startDate, Date endDate, Room room);

}
