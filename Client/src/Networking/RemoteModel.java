package Networking;

import Model.Room;
import utility.observer.subject.RemoteSubject;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteModel extends RemoteSubject {
    Room getRoomByAnnouncement(String announcement) throws RemoteException;
    void addRoom(Room room) throws RemoteException;
    void removeRoom(Room room) throws RemoteException;
    ArrayList<Room> getAllRooms() throws RemoteException;
    void addUser(String firstName, String lastName, String username, String password, String phoneNumber) throws RemoteException;
}