package Networking;

import Model.Rating;
import Model.Reservation;
import Model.Room;
import Model.User;
import utility.observer.subject.RemoteSubject;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteModel extends RemoteSubject {
    Room getRoomByAnnouncement(String announcement) throws RemoteException;
    void addRoom(Room room) throws RemoteException;
    void removeRoom(Room room) throws RemoteException;
    ArrayList<Room> getAllRooms() throws RemoteException;
    public ArrayList<Reservation> getAllReservationsByUsername(String username) throws RemoteException;
    void addReservation(Reservation reservation) throws  RemoteException;
    Reservation getReservationById(String id) throws  RemoteException;
    void removedReservation(Reservation reservation) throws RemoteException;
    void addUser(User user) throws RemoteException;
    User getUserByUsername(String username) throws RemoteException;
    boolean setRoomReserved(Room room) throws RemoteException;
    boolean setRoomFree(Room room) throws RemoteException;
    boolean setUserInfo(User user) throws RemoteException;
    void sendFile(String name,byte[] img) throws RemoteException;
    User getUser(String username, String password) throws RemoteException;
    ArrayList<Room> getRoomsByUsername(String username) throws RemoteException;
    Room getRoomById(String Id) throws RemoteException;

    void addRating(Rating rating) throws RemoteException;
    int getRating() throws RemoteException;

    double getAvgRatingById(String id) throws RemoteException;

}