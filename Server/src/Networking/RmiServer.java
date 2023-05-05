package Networking;

import Model.ModelServer;
import Model.Reservation;
import Model.Room;
import Model.User;
import utility.observer.listener.GeneralListener;
import utility.observer.subject.PropertyChangeHandler;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
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
        System.out.println("Got Room by announcement");
        return model.getRoomByAnnouncement(announcement);
    }

    @Override public void addRoom(Room room) throws RemoteException {
        System.out.println("Added Room");
        model.addRoom(room);
        property.firePropertyChange("AddRoom", null, room);
    }

    @Override public void removeRoom(Room room) throws RemoteException {
        System.out.println("Removed Room");
        model.removeRoom(room);
        property.firePropertyChange("RemoveRoom", null, model.getAllRooms());
    }

    @Override public ArrayList<Room> getAllRooms() throws RemoteException {
        System.out.println("Got All Rooms");
        return model.getAllRooms();
    }

    @Override
    public ArrayList<Reservation> getAllReservations() throws RemoteException {
        return model.getAllReservations();
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
        System.out.println("Added User");
        model.addUser(user);
    }

    @Override public Reservation getReservationById(String id)
        throws RemoteException
    {
        return model.getReservationById(id);
    }

    @Override public void removedReservation(Reservation reservation)
        throws RemoteException
    {
        model.removeReservation(reservation);
        property.firePropertyChange("removereservation", null ,reservation.toString());
    }
}
