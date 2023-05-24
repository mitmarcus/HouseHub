package Model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface ModelClient extends UnnamedPropertyChangeSubject {
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
    Reservation getReservationById(String id);
    boolean setRoomReserved(Room room);
    boolean setRoomFree(Room room);
    boolean setUserInfo(User user);
    User getUser(String username, String password);
    void sendFile(String roomId, String name, byte[] img);
    ArrayList<Room> getRoomsByUsername(String username);
    Room getRoomById(String Id);
    ArrayList<String> getRoomImagesPaths(String roomId);
    void addRating(Rating rating);
    boolean hasUserRated(String username, String roomId);
    double getAvgRatingById(String id);
    void sendNotification(String owner, String tenant, String roomId);
    ArrayList<String> getAllNotificationsByUsername(String username);
    void removeNotification(String notification);
}
