package Networking;
import ModelClient.Room;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.GeneralListener;
import utility.observer.listener.RemoteListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiClient implements RemoteModel, RemoteListener // with Callback
{
    private RemoteModel server;
    private PropertyChangeSupport property;
    public RmiClient(){
        this.property=new PropertyChangeSupport(this);
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = (RemoteModel) Naming.lookup("rmi://localhost:1099/SERVER");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public Room getRoomByAnnouncement(String announcement) throws RemoteException {
        return null;
    }

    @Override
    public void addRoom(Room room) throws RemoteException {

    }

    @Override
    public void removeRoom(Room room) throws RemoteException {

    }

    @Override
    public ArrayList<Room> getAllRooms() throws RemoteException {
        return null;
    }


    @Override
    public void propertyChange(ObserverEvent evt) throws RemoteException {
        String name = evt.getPropertyName();
        property.firePropertyChange(name, evt.getValue1(), evt.getValue2());
    }

    @Override
    public boolean addListener(GeneralListener listener, String... propertyNames) throws RemoteException {
        property.addPropertyChangeListener((PropertyChangeListener) listener);
        return true;
    }

    @Override
    public boolean removeListener(GeneralListener listener, String... propertyNames) throws RemoteException {
        property.removePropertyChangeListener((PropertyChangeListener) listener);
        return true;
    }
}


