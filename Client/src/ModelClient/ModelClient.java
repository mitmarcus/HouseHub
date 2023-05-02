package ModelClient;

import javafx.scene.control.DatePicker;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface ModelClient extends UnnamedPropertyChangeSubject
{
  void addRoom(Room room);
  void removeRoom(Room room);
  Room getRoomByAnnouncement(String announcement);
  ArrayList<Room> getAllRooms();
  void addReservation(LocalDate startDate, LocalDate endDate, Room room);
  void removeReservation(LocalDate startDate, LocalDate endDate, Room room);
  void addUser(String firstName, String lastName, String username, String password, String phoneNumber);
  void removeUserByUsername(String username);
  void removeUserByPhoneNumber(String phoneNumber);
}
