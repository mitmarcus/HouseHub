package ModelClient;

import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManagerClient implements ModelClient
{
    private RoomList rooms;
    private ReservationList reservations;


    public ModelManagerClient ()
    {
        this.rooms = new RoomList();
        this.reservations = new ReservationList();
        this.rooms.addRoom(new Room("Room next Lovbjerg.","$300", "123 Main St", "200", "3"));
        this.rooms.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2"));
        this.rooms.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1"));
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
    public void addReservation(LocalDate startDate, LocalDate endDate,
        Room room) {
        reservations.addReservation(startDate, endDate, room);
    }

    @Override
    public void removeReservation(LocalDate startDate, LocalDate endDate, Room room) {
        reservations.removeReservation(startDate,endDate, room);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
    }
    @Override
    public void removeListener(PropertyChangeListener listener) {
    }
}
