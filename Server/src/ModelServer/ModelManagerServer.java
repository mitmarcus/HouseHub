package ModelServer;

import java.util.ArrayList;
import java.util.Date;

public class ModelManagerServer implements ModelServer
{
    private RoomList rooms;
    private ReservationList reservations;
    private UserList users;

    public ModelManagerServer()
    {
        this.rooms = new RoomList();
        this.rooms.addRoom(new Room("Room next Lovbjerg.",null, "123 Main St", "200", "3"));
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
    public void addReservation(Date startDate, Date endDate, Room room) {
        reservations.addReservation(startDate, endDate, room);
    }

    @Override
    public void removeReservation(Date startDate, Date endDate, Room room) {
        reservations.removeReservation(startDate,endDate, room);
    }

    @Override
    public void addUser(String firstName, String lastName, String username, String password, String phoneNumber) {
        users.addUser(firstName,lastName, username, password, phoneNumber);
    }

    @Override
    public void removeUserByUsername(String username) {
        users.removeUserByUsername(username);
    }

    @Override
    public void removeUserByPhoneNumber(String phoneNumber) {
        users.removeUserByPhoneNumber(phoneNumber);
    }

}
