package Networking;
import Model.*;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.RemoteListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
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

    @Override public void addUser(User user)
    {
        try {
            server.addUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            return server.getUserByUsername(username);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public Reservation getReservationById(String id)
    {
        try
        {
            return server.getReservationById(id);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public boolean setRoomReserved(Room room)
    {
        try
        {
            server.setRoomReserved(room);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override public boolean setRoomFree(Room room)
    {
        try
        {
            server.setRoomFree(room);
        }
        catch (RemoteException e)
        {
            e.getMessage();
                }
        return  true;
    }

    @Override public boolean setUserInfo(User user)
    {
        try
        {
            server.setUserInfo(user);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public User getUser(String username, String password) {
        try {
            return server.getUser(username, password);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public void sendFile(String roomId,String name, byte[] img)
    {
        try
        {
            server.sendFile(roomId,name,img);
        }
        catch (RemoteException e)
        {
            e.getMessage();
        }
    }

    @Override public ArrayList<Room> getRoomsByUsername(String username)
    {
        try
        {
            return server.getRoomsByUsername(username);
        }
        catch (RemoteException e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override public Room getRoomById(String Id)
    {
        try
        {
            return server.getRoomById(Id);
        }
        catch (RemoteException e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override public ArrayList<String> getRoomImagesPaths(String roomId)
    {
        try
        {
            return  server.getRoomImagesPaths(roomId);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public void removeReservation(Reservation reservation)
    {
        try
        {
            server.removedReservation(reservation);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
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
    public ArrayList<Reservation> getAllReservationsByUsername(String username) {
        try {
            return server.getAllReservationsByUsername(username);
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

    @Override public void addRating(Rating rating)
    {
        try
        {server.addRating(rating);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasUserRated(String username, String roomId) {
        try {
            return server.hasUserRated(username,roomId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public double getAvgRatingById(String id) {
        try
        {
            return server.getAvgRatingById(id);
        }
        catch (RemoteException e)
        {
            e.getMessage();
        }
        return 0;
    }

    @Override public void sendNotification(String owner, String tenant,
        String roomId)
    {
        try
        {
            server.sendNotification(owner,tenant,roomId);
        }
        catch (RemoteException e)
        {
            e.getMessage();
        }
    }


    /*@Override public void deletePictures(String roomId)
    {
        try
        {
            server.deletePictures(roomId);
        }
        catch (RemoteException e)
        {
            e.getMessage();
        }
    }*/

    public ArrayList<String> getAllNotificationsByUsername(String username){
        try {
            return server.getAllNotificationsByUsername(username);
        } catch (RemoteException e) {
            e.getMessage();
        }
        return  null;
    }

   public void removeNotification(String notification)
   {
       try
       {
           server.removeNotification(notification);
       }
       catch (RemoteException e)
       {
           e.getMessage();
       }
   }

}


