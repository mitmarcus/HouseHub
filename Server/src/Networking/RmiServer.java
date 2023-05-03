package Networking;

import Model.ModelServer;
import Model.Room;
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
        property.firePropertyChange("RemoveRoom", null, room);
    }

    @Override public ArrayList<Room> getAllRooms() throws RemoteException {
        System.out.println("Got All Rooms");
        return model.getAllRooms();
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
    public void addUser(String firstName, String lastName, String username, String password, String phoneNumber) throws RemoteException {
        System.out.println("Added User");
        model.addUser(firstName, lastName, username, password, phoneNumber);
    }
}
