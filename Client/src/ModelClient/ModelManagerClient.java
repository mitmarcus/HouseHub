package ModelClient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManagerClient implements ModelClient
{
    private PropertyChangeSupport property;
    private RoomList rooms;
    private ReservationList reservations;
    private UserList users;


    public ModelManagerClient ()
    {
        this.rooms = new RoomList();
        this.reservations = new ReservationList();
        this.rooms.addRoom(new Room("Room next Lovbjerg.","$300", "123 Main St", "200", "3",false));
        this.rooms.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2",false));
        this.rooms.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1",false));
    }
    @Override
    public void addRoom(Room room) {
        rooms.addRoom(room);
    }

    @Override
    public void removeRoom(Room room) {
        rooms.removeRoom(room);
    }

    @Override
    public Room getRoomByAnnouncement(String announcement) {
        return rooms.getRoomByAnnouncement(announcement);
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return rooms.getAllRooms();
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservations.addReservation(reservation);
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservations.removeReservation(reservation);
    }

    @Override
    public void addUser(String firstName, String lastName, String username, String password, String phoneNumber) {
        users.addUser(firstName, lastName, username, password, phoneNumber);
    }

    @Override
    public void removeUserByUsername(String username) {
        users.removeUserByUsername(username);
    }

    @Override
    public void removeUserByPhoneNumber(String phoneNumber) {
        users.removeUserByPhoneNumber(phoneNumber);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }
    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
