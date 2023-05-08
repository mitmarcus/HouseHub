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

  ArrayList<Reservation> getAllReservations();

  Reservation getReservationAtIndex();
  Reservation getReservationAtIndex(int index);
  void removeReservation(Reservation reservation);
  void addUser(User user);
  User getUserByUsername(String username);
  void removeUserByUsername(String username);
  void removeUserByPhoneNumber(String phoneNumber);
  Reservation getReservationById(String id);
  void addUser(String firstName,String lastName, String username, String password, String phoneNumber);
}
