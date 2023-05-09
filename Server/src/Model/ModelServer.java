package Model;

import java.rmi.RemoteException;
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
  boolean setRoomReserved(Room room) throws RemoteException;
  boolean setRoomFree(Room room);
  User getUser(String username, String password);
}
