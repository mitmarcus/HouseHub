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

    /**
     * This constructor is used to create a RMI client
     */
    public RmiClient() {
        this.property = new PropertyChangeSupport(this);
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = (RemoteModel) Naming.lookup("rmi://localhost:1099/SERVER");
            server.addListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to add a room
     *
     * @param room the room
     */
    @Override
    public void addRoom(Room room) {
        try {
            server.addRoom(room);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to remove a room
     *
     * @param room the room
     */
    @Override
    public void removeRoom(Room room) {
        try {
            server.removeRoom(room);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get a room by announcement
     *
     * @param announcement the announcement of the room
     * @return the room with the given announcement or null if there is no room with the given announcement
     */
    @Override
    public Room getRoomByAnnouncement(String announcement) {
        try {
            return server.getRoomByAnnouncement(announcement);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to get all rooms
     *
     * @return all rooms
     */
    @Override
    public ArrayList<Room> getAllRooms() {
        try {
            return server.getAllRooms();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to add a add User
     *
     * @param user the user
     */
    @Override
    public void addUser(User user) {
        try {
            server.addUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get a user by username
     *
     * @param username the username of the user
     */
    @Override
    public User getUserByUsername(String username) {
        try {
            return server.getUserByUsername(username);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to ge the reservation by id
     *
     * @return the reservation with the given id
     */
    @Override
    public Reservation getReservationById(String id) {
        try {
            return server.getReservationById(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used set the room reserved
     *
     * @return true if the room is reserved
     */
    @Override
    public boolean setRoomReserved(Room room) {
        try {
            server.setRoomReserved(room);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * This method is used to set the room free
     * @param room the room
     * @return true if the room is free
     */
    @Override
    public boolean setRoomFree(Room room) {
        try {
            server.setRoomFree(room);
        } catch (RemoteException e) {
            e.getMessage();
        }
        return true;
    }

    /**
     * This method is used to set the User info
     * @param user the user
     * @return true if the user info is set
     */
    @Override
    public boolean setUserInfo(User user) {
        try {
            server.setUserInfo(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * This method is used to get the user by username and password
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the user with the given username and password
     */
    @Override
    public User getUser(String username, String password) {
        try {
            return server.getUser(username, password);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to sed the image to the server
     *
     * @param roomId the room id
     * @param name the name of the image
     * @param img the image
     */
    @Override
    public void sendFile(String roomId, String name, byte[] img) {
        try {
            server.sendFile(roomId, name, img);
        } catch (RemoteException e) {
            e.getMessage();
        }
    }

    /**
     * This method is used to get the rooms according to the username
     *
     * @param username
     * @return ArrayList of rooms according to the username
     */
    @Override
    public ArrayList<Room> getRoomsByUsername(String username) {
        try {
            return server.getRoomsByUsername(username);
        } catch (RemoteException e) {
            e.getMessage();
        }
        return null;
    }
/**
     * This method is used to get the room by id
     *
     * @param Id the room id
     * @return the room with the given id
 */
    @Override
    public Room getRoomById(String Id) {
        try {
            return server.getRoomById(Id);
        } catch (RemoteException e) {
            e.getMessage();
        }
        return null;
    }
/**
     * This method is used to get the room images paths
     *
     * @param roomId the room id
     * @return ArrayList of room images paths
 */
    @Override
    public ArrayList<String> getRoomImagesPaths(String roomId) {
        try {
            return server.getRoomImagesPaths(roomId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to remove a reservation
     *
     * @param reservation the reservation
     */
    @Override
    public void removeReservation(Reservation reservation) {
        try {
            server.removedReservation(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to add a reservation
     *
     * @param reservation the reservation
     */
    @Override
    public void addReservation(Reservation reservation) {
        try {
            server.addReservation(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get all reservations by username
     *
     * @return ArrayList of all reservations by username or null if there is no reservations
     */
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

    /**
     * Add a listener to the model
     *
     * @param listener the listener to be added
     */
    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    /**
     * Remove a listener from the model
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
     * @param event the event fired
     * @throws RemoteException if the remote method call fails
     */
    @Override
    public void propertyChange(ObserverEvent event)
            throws RemoteException {
        property.firePropertyChange(event.getPropertyName(), event.getValue1(), event.getValue2());

    }

    /**
     * This method is used to add a rating
     *
     * @param rating the rating
     */
    @Override
    public void addRating(Rating rating) {
        try {
            server.addRating(rating);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get the rating by room id
     *
     * @param roomId the room id
     * @return the rating by room id
     */
    @Override
    public boolean hasUserRated(String username, String roomId) {
        try {
            return server.hasUserRated(username, roomId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to get the average rating by room id
     *
     * @param id the id
     * @return the average rating by room id
     */
    @Override
    public double getAvgRatingById(String id) {
        try {
            return server.getAvgRatingById(id);
        } catch (RemoteException e) {
            e.getMessage();
        }
        return 0;
    }

    /**
     * This method is used to send a notification
     *
     * @param owner  the owner
     * @param tenant the tenant
     * @param roomId the room id
     */
    @Override
    public void sendNotification(String owner, String tenant,
                                 String roomId) {
        try {
            server.sendNotification(owner, tenant, roomId);
        } catch (RemoteException e) {
            e.getMessage();
        }
    }

    /**
     * This method is used to get all notifications by username
     *
     * @param username the username
     * @return all notifications by username
     */
    @Override
    public ArrayList<String> getAllNotificationsByUsername(String username) {
        try {
            return server.getAllNotificationsByUsername(username);
        } catch (RemoteException e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * This method is used to remove a notification
     *
     * @param notification the notification
     */
    @Override
    public void removeNotification(String notification) {
        try {
            server.removeNotification(notification);
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
}


