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
  void addReservation(Reservation reservation);
  void removeReservation(Reservation reservation);
}
