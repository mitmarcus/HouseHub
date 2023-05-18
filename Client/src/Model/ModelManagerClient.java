package Model;

import Networking.RmiClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManagerClient implements ModelClient,PropertyChangeListener
{
    private PropertyChangeSupport property;
    private ModelClient client;

    public ModelManagerClient ()
    {
        this.property = new PropertyChangeSupport(this);
        this.client = new RmiClient();
        this.client.addListener(this);
    }
    @Override
    public void addRoom(Room room) {
        client.addRoom(room);
    }

    @Override
    public void removeRoom(Room room) {
        client.removeRoom(room);
    }

    @Override
    public Room getRoomByAnnouncement(String announcement) {
        return client.getRoomByAnnouncement(announcement);
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return client.getAllRooms();
    }

    @Override
    public void addReservation(Reservation reservation) {
        client.addReservation(reservation);
    }

    @Override public ArrayList<Reservation> getAllReservationsByUsername(String username)
    {
        return client.getAllReservationsByUsername(username);
    }

    @Override public Reservation getReservationAtIndex()
    {
        return null;
    }

    @Override public Reservation getReservationAtIndex(int index)
    {
        return null;
    }


    @Override
    public void removeReservation(Reservation reservation) {
        client.removeReservation(reservation);
    }

    @Override
    public void addUser(User user) {
        client.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return client.getUserByUsername(username);
    }

    @Override public Reservation getReservationById(String id)
    {
        return client.getReservationById(id);
    }

    @Override public boolean setRoomReserved(Room room)
    {
        client.setRoomReserved(room);
        return true;
    }

    @Override public boolean setRoomFree(Room room)
    {
        client.setRoomFree(room);
        return true;
    }

    @Override public boolean setUserInfo(User user)
    {
        client.setUserInfo(user);
        return true;
    }

    @Override
    public User getUser(String username, String password) {
        return client.getUser(username,password);
    }

    @Override public void sendFile(String roomId,String name, byte[] img)
    {
        client.sendFile(roomId,name,img);
    }

    @Override public ArrayList<Room> getRoomsByUsername(String username)
    {
        return client.getRoomsByUsername(username);
    }

    @Override public Room getRoomById(String Id)
    {
        return client.getRoomById(Id);
    }


    @Override public ArrayList<String> getRoomImagesPaths(String roomId)
    {
        return client.getRoomImagesPaths(roomId);
    }


    @Override public void addRating(Rating rating)
    {
        client.addRating(rating);
    }

    @Override
    public double getAvgRatingById(String id) {
        return client.getAvgRatingById(id);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }
    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        property.firePropertyChange(evt.getPropertyName(),evt.getOldValue(),evt.getNewValue());
    }
}
