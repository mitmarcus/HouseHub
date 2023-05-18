package Networking;

import Model.*;
import utility.observer.listener.GeneralListener;
import utility.observer.subject.PropertyChangeHandler;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class RmiServer implements RemoteModel
{
    private ModelServer model;
    private PropertyChangeHandler property;

    public RmiServer(ModelServer model) throws Exception {
        this.model = model;
        this.property = new PropertyChangeHandler(this);
        startRegistry();
        startServer();
    }


    private void startServer() throws MalformedURLException, RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        Naming.rebind("SERVER", this);
        System.out.println("Server started...");
    }

    private void startRegistry() throws Exception {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            System.out.println("Registry started...");
        } catch (RemoteException e) {
            throw new Exception("Registry already started? " + e.getMessage());
        }
    }

    @Override public Room getRoomByAnnouncement(String announcement) throws RemoteException{
        return model.getRoomByAnnouncement(announcement);
    }

    @Override public void addRoom(Room room) throws RemoteException {
        model.addRoom(room);
        property.firePropertyChange("AddRoom", null, room);
    }

    @Override public void removeRoom(Room room) throws RemoteException {
        model.removeRoom(room);
        property.firePropertyChange("RemoveRoom", null, model.getAllRooms());
    }

    @Override public ArrayList<Room> getAllRooms() throws RemoteException {
        return model.getAllRooms();
    }

    @Override
    public ArrayList<Reservation> getAllReservationsByUsername(String username) throws RemoteException {
        return model.getAllReservationsByUsername(username);
    }

    @Override
    public void addReservation(Reservation reservation) throws RemoteException {
        model.addReservation(reservation);
        property.firePropertyChange("reserve",null,reservation);
    }



    @Override
    public boolean addListener(GeneralListener listener, String... propertyNames) throws RemoteException {
        property.addListener(listener,propertyNames);
        return true;
    }

    @Override
    public boolean removeListener(GeneralListener listener, String... propertyNames) throws RemoteException {
        property.removeListener(listener,propertyNames);
        return true;
    }

    @Override
    public void addUser(User user) throws RemoteException {
        model.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) throws RemoteException {
        return model.getUserByUsername(username);
    }

    @Override public boolean setRoomReserved(Room room) throws RemoteException
    {
        model.setRoomReserved(room);
        property.firePropertyChange("roomReserved", null,room);
        return true;
    }

    @Override public boolean setRoomFree(Room room) throws RemoteException
    {
        model.setRoomFree(room);
        return true;
    }

    @Override public boolean setUserInfo(User user) throws RemoteException {
        model.setUserInfo(user);
        return true;
    }

    @Override public void sendFile(String roomId,String name, byte[] img)
        throws RemoteException
    {
        model.sendFile(roomId,name,img);
    }

    @Override
    public User getUser(String username, String password) {
        return model.getUser(username,password);
    }

    @Override public ArrayList<Room> getRoomsByUsername(String username)
        throws RemoteException
    {
        return model.getRoomsByUsername(username);
    }

    @Override public Room getRoomById(String Id) throws RemoteException
    {
        return model.getRoomById(Id);
    }

    @Override public ArrayList<String> getRoomImagesPaths(String roomId)
        throws RemoteException
    {
        return model.getRoomImagesPaths(roomId);
    }


    @Override public void addRating(Rating rating) throws RemoteException
    {
        model.addRating(rating);
    }

    @Override
    public double getAvgRatingById(String id) throws RemoteException {
        return model.getAvgRatingById(id);
    }

    @Override public void sendNotification(String owner, String tenant,
        String roomId) throws RemoteException
    {
        model.sendNotification(owner,tenant,roomId);
    }

    @Override public Reservation getReservationById(String id)
        throws RemoteException
    {
        return model.getReservationById(id);
    }

    @Override public void removedReservation(Reservation reservation)
        throws RemoteException {
        model.removeReservation(reservation);
        property.firePropertyChange("removeReservation", null ,reservation.toString());
    }

}
