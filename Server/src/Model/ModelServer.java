package Model;

import java.util.ArrayList;

public interface ModelServer
{
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();
  void addReservation(Reservation reservation);
  ArrayList<Reservation> getAllReservations();
  void removeReservation(Reservation reservation);
  void addUser(User user);
  User getUserByUsername(String username);
  void removeUserByUsername(String username);
  void removeUserByPhoneNumber(String phoneNumber);
  Reservation getReservationById(String id);

}
