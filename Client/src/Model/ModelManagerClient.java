package Model;

import Networking.RmiClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManagerClient implements ModelClient, PropertyChangeListener {
    private PropertyChangeSupport property;
    private ModelClient client;

    /**
     * This constructor is used to create a model manager client
     */
    public ModelManagerClient() {
        this.property = new PropertyChangeSupport(this);
        this.client = new RmiClient();
        this.client.addListener(this);
    }

    /**
     * This method is used to add a room
     *
     * @param room
     */
    @Override
    public void addRoom(Room room) {
        client.addRoom(room);
    }

    /**
     * This method is used to remove a room
     *
     * @param room the room
     */
    @Override
    public void removeRoom(Room room) {
        client.removeRoom(room);
    }

    /**
     * This method is used to get a room by announcement
     *
     * @param announcement the announcement of the room
     * @return the room with the given announcement
     */
    @Override
    public Room getRoomByAnnouncement(String announcement) {
        return client.getRoomByAnnouncement(announcement);
    }

    /**
     * This method is used to get all rooms
     *
     * @return all rooms
     */
    @Override
    public ArrayList<Room> getAllRooms() {
        return client.getAllRooms();
    }

    /**
     * This method is used to add a reservation
     *
     * @param reservation the reservation
     */
    @Override
    public void addReservation(Reservation reservation) {
        client.addReservation(reservation);
    }

    /**
     * This method is used to get all reservations by username
     *
     * @param username the username of the user
     * @return all reservations by username
     */
    @Override
    public ArrayList<Reservation> getAllReservationsByUsername(String username) {
        return client.getAllReservationsByUsername(username);
    }

    /**
     * This method is used to get a reservation by index
     *
     * @return the reservation with the given index
     */
    @Override
    public Reservation getReservationAtIndex() {
        return null;
    }

    /**
     * This method is used to get a reservation by index
     *
     * @param index the index of the reservation
     * @return the reservation with the given index
     */
    @Override
    public Reservation getReservationAtIndex(int index) {
        return null;
    }

    /**
     * This method is used to remove a reservation
     *
     * @param reservation the reservation
     */
    @Override
    public void removeReservation(Reservation reservation) {
        client.removeReservation(reservation);
    }

    /**
     * This method is used to add a user
     *
     * @param user the user
     */
    @Override
    public void addUser(User user) {
        client.addUser(user);
    }

    /**
     * This method is used to get a user by username
     *
     * @param username the username of the user
     * @return the user with the given username
     */
    @Override
    public User getUserByUsername(String username) {
        return client.getUserByUsername(username);
    }

    /**
     * This method is used to get a reservation by id
     *
     * @param id the id of the reservation
     * @return the reservation with the given id
     */
    @Override
    public Reservation getReservationById(String id) {
        return client.getReservationById(id);
    }

    /**
     * This method is used to set a room reserved
     *
     * @param room the room
     * @return true
     */
    @Override
    public boolean setRoomReserved(Room room) {
        client.setRoomReserved(room);
        return true;
    }

    /**
     * This method is used to set a room free
     *
     * @param room the room
     * @return true
     */
    @Override
    public boolean setRoomFree(Room room) {
        client.setRoomFree(room);
        return true;
    }

    /**
     * This method is used to set the user info
     *
     * @param user the user
     * @return true
     */
    @Override
    public boolean setUserInfo(User user) {
        client.setUserInfo(user);
        return true;
    }

    /**
     * This method is used to get a user
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the user with the given username and password
     */
    @Override
    public User getUser(String username, String password) {
        return client.getUser(username, password);
    }

    /**
     * This method is used to send a file
     *
     * @param roomId the id of the room
     * @param name   the name of the file
     * @param img    the image
     */
    @Override
    public void sendFile(String roomId, String name, byte[] img) {
        client.sendFile(roomId, name, img);
    }

    /**
     * This method is used to get the rooms of a user
     *
     * @param username the username of the user
     * @return an ArrayList of Rooms containing the rooms of the user
     */
    @Override
    public ArrayList<Room> getRoomsByUsername(String username) {
        return client.getRoomsByUsername(username);
    }

    /**
     * This method is used to get a room by id
     *
     * @param Id the id of the room
     * @return the room with the given id
     */
    @Override
    public Room getRoomById(String Id) {
        return client.getRoomById(Id);
    }

    /**
     * This method is used to get the paths of the images of a room
     *
     * @param roomId the id of the room
     * @return an ArrayList of Strings containing the paths of the images
     */
    @Override
    public ArrayList<String> getRoomImagesPaths(String roomId) {
        return client.getRoomImagesPaths(roomId);
    }

    /**
     * This method is used to add a rating
     *
     * @param rating the rating to be added
     */
    @Override
    public void addRating(Rating rating) {
        client.addRating(rating);
    }

    /**
     * This method is used to check if a user has rated a room
     *
     * @param username the username of the user
     * @param roomId   the id of the room
     * @return true if the user has rated the room, false otherwise
     */
    @Override
    public boolean hasUserRated(String username, String roomId) {
        return client.hasUserRated(username, roomId);
    }

    /**
     * This method is used to get the average rating by id
     *
     * @param id the id of the room
     * @return the average rating
     */
    @Override
    public double getAvgRatingById(String id) {
        return client.getAvgRatingById(id);
    }

    /**
     * This method is used to send a notification
     *
     * @param owner  the owner of the room
     * @param tenant the tenant of the room
     * @param roomId the id of the room
     */
    @Override
    public void sendNotification(String owner, String tenant, String roomId) {
        client.sendNotification(owner, tenant, roomId);
    }

    /**
     * This method is used to get all notifications by username
     *
     * @param username the username
     * @return an array list of notifications
     */
    @Override
    public ArrayList<String> getAllNotificationsByUsername(String username) {
        return client.getAllNotificationsByUsername(username);
    }

    /**
     * This method is used to remove a notification
     *
     * @param notification the notification to be removed
     */
    @Override
    public void removeNotification(String notification) {
        client.removeNotification(notification);
    }

    /**
     * This method is used to add a listener
     *
     * @param listener the listener to be added
     */
    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    /**
     * This method is used to remove a listener
     *
     * @param listener the listener to be removed
     */
    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    /**
     * This method is used to fire a property change event
     *
     * @param evt the event to be fired
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        property.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }
}
