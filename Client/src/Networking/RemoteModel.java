package Networking;

import Model.*;
import utility.observer.subject.RemoteSubject;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteModel extends RemoteSubject
{
    Room getRoomByAnnouncement(String announcement) throws RemoteException;
    void addRoom(Room room) throws RemoteException;
    void removeRoom(Room room) throws RemoteException;
    ArrayList<Room> getAllRooms() throws RemoteException;
    public ArrayList<Reservation> getAllReservations() throws RemoteException;
    void addReservation(Reservation reservation) throws RemoteException;

    void addUser(String firstName, String lastName, String username, String password, String phoneNumber) throws RemoteException;
    Reservation getReservationById(String id) throws RemoteException;
    void removedReservation(Reservation reservation) throws RemoteException;
    void addUser(User user) throws RemoteException;
    User getUserByUsername(String username) throws RemoteException;
    boolean setRoomReserved(Room room) throws RemoteException;
    boolean setRoomFree(Room room) throws  RemoteException;
    boolean setUserInfo(User user) throws RemoteException;

    User getUser(String username, String password) throws RemoteException;
}