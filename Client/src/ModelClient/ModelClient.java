package ModelClient;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;
public interface ModelClient extends UnnamedPropertyChangeSubject
{
  boolean connectToServer(String host, int port);
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();
}
