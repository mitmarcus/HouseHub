package Model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface ModelClient extends UnnamedPropertyChangeSubject
{
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();
  void addReservation(Reservation reservation);

  ArrayList<Reservation> getAllReservationsByUsername(String username);

  Reservation getReservationAtIndex();
  Reservation getReservationAtIndex(int index);
  void removeReservation(Reservation reservation);
  void addUser(User user);
  User getUserByUsername(String username);
  void removeUserByUsername(String username);
  void removeUserByPhoneNumber(String phoneNumber);
  Reservation getReservationById(String id);
  boolean setRoomReserved(Room room);
  boolean setRoomFree(Room room);
  boolean setUserInfo(User user);
  User getUser(String username, String password);
  void sendFile(String name,byte[] img);
}
