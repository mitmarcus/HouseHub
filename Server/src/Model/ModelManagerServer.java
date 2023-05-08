package Model;

import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManagerServer implements ModelServer
{
    private RoomList rooms;
    private ReservationList reservations;
    private UserList users;

    public ModelManagerServer()
    {
        this.rooms = new RoomList();
        this.reservations = new ReservationList();
        this.rooms.addRoom(new Room("Room next Lovbjerg.","300", "123 Main St", "200", "3",false));
        this.rooms.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2",false));
        this.rooms.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1",false));
        LocalDate start = LocalDate.of(2022, 7, 15);
        LocalDate end =  LocalDate.of(2022, 7, 30);
        User user = new User("Nuri", "Hasan", "nuriHasan", "nuriSexyBoy", "00000007");

        Reservation reservation = new Reservation(user,start,end,new Room("Room next Lovbjerg.","700", "123 Main St", "200", "3",true));
        this.reservations.addReservation(reservation);

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
    public ArrayList<Reservation> getAllReservations() {
        return reservations.getAllReservations();
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservations.removeReservation(reservation);
    }

    @Override
    public void addUser(User user) {
        System.out.println(user.toString());
        users.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return users.getUserByUsername(username);
    }

    @Override
    public void removeUserByUsername(String username) {
        users.removeUserByUsername(username);
    }

    @Override
    public void removeUserByPhoneNumber(String phoneNumber) {
        users.removeUserByPhoneNumber(phoneNumber);
    }

    @Override public Reservation getReservationById(String id)
    {
        return reservations.getReservationById(id);
    }
    public User getUser(String username, String password) {
        return users.getUser(username,password);
    }
}
