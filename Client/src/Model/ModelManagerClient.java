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

    @Override public ArrayList<Reservation> getAllReservations()
    {
        return client.getAllReservations();
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
    public void removeUserByUsername(String username) {
        client.removeUserByUsername(username);
    }

    @Override
    public void removeUserByPhoneNumber(String phoneNumber) {
        client.removeUserByPhoneNumber(phoneNumber);
    }

    @Override public Reservation getReservationById(String id)
    {
        return client.getReservationById(id);
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
