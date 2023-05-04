package Networking;
import Model.*;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.RemoteListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiClient implements ModelClient, RemoteListener // with Callback
{
    private RemoteModel server;
    private PropertyChangeSupport property;
    public RmiClient(){
        this.property=new PropertyChangeSupport(this);
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = (RemoteModel) Naming.lookup("rmi://localhost:1099/SERVER");
            server.addListener(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override public void addRoom(Room room)
    {
        try
        {
            server.addRoom(room);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public void removeRoom(Room room)
    {
        try
        {
            server.removeRoom(room);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public Room getRoomByAnnouncement(String announcement)
    {
        try
        {
            return server.getRoomByAnnouncement(announcement);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public ArrayList<Room> getAllRooms()
    {
        try
        {
            return server.getAllRooms();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public void addUser(String firstName, String lastName,
        String username, String password, String phoneNumber)
    {
        try {
            server.addUser(firstName, lastName, username, password, phoneNumber);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override public void removeUserByUsername(String username)
    {

    }

    @Override public void removeUserByPhoneNumber(String phoneNumber)
    {

    }

    @Override public void removeReservation(Reservation reservation)
    {

    }

    @Override public void addReservation(Reservation reservation)
    {
        try {
            server.addReservation(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        try {
            return server.getAllReservations();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservation getReservationAtIndex() {
        return null;
    }

    @Override
    public Reservation getReservationAtIndex(int index) {
        return null;
    }

    @Override public void addListener(PropertyChangeListener listener)
    {
        property.addPropertyChangeListener(listener);
    }

    @Override public void removeListener(PropertyChangeListener listener)
    {
        property.removePropertyChangeListener(listener);
    }

    @Override public void propertyChange(ObserverEvent event)
        throws RemoteException
    {
        property.firePropertyChange(event.getPropertyName(),event.getValue1(),event.getValue2() );

    }

}


