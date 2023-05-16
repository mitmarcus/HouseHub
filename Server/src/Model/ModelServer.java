package Model;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelServer
{
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();
  void addReservation(Reservation reservation);
  ArrayList<Reservation> getAllReservationsByUsername(String username);
  Reservation getReservationById(String id);
  void removeReservation(Reservation reservation);
  void addUser(User user);
  User getUserByUsername(String username);
  User getUser(String username, String password);
  boolean setRoomReserved(Room room) throws RemoteException;
  boolean setRoomFree(Room room);
  void sendFile(String name,byte[] img);
  boolean setUserInfo(User user);
  ArrayList<Room> getRoomsByUsername(String username);
  Room getRoomById(String Id);

  void addRating(Rating rating);

  int getRating();




}
