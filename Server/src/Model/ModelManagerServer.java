package Model;

import Database.reservation.ReservationDAO;

import Database.reservation.ReservationDAOImpl;

import Database.room.RoomDAO;

import Database.user.UserDAO;
import Database.user.UserDAOImpl;

import java.nio.file.attribute.UserPrincipal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManagerServer implements ModelServer
{
    private RoomList rooms;
    private ReservationList reservations;
    private UserList users;
    private UserDAO userDB;

    private ReservationDAO reservationDAO;

    private RoomDAO roomDB;


    public ModelManagerServer()
    {
        try
        {
            this.reservationDAO = ReservationDAOImpl.getInstance();
            this.userDB = UserDAOImpl.getInstance();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        this.users = new UserList();
        this.rooms = new RoomList();
        this.reservations = new ReservationList();
        this.rooms.addRoom(new Room("Room next Lovbjerg.","300", "123 Main St", "200", "3",false));
        this.rooms.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2",false));
        this.rooms.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1",false));
        User user = new User("Nuri", "Hasan", "nuriSexyBoy", "nuriSexyBoy", "00000007");
        users.addUser(user);


    }

    @Override
    public void addRoom(Room room) {
        try {
            roomDB.addRoom(room);
        } catch (SQLException e) {
            e.getMessage();
        }
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
        try {
            reservation.getRoom().incrementID();
            reservation.incrementID();
            reservationDAO.addReservation(reservation);
        } catch (SQLException e) {
            System.out.println("Model manager error in add reservation");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        try {
            return reservationDAO.getAllReservations();
        } catch (SQLException e) {
            System.out.println("Error in getAllReservations() in Model Manager. ");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservations.removeReservation(reservation);
    }

    @Override
    public void addUser(User user) {
        try
        {
            userDB.addUser(user);

        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try
        {
            return userDB.getUserByUsername(username);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
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

    @Override public boolean setRoomReserved(Room room) throws RemoteException
    {
        rooms.setRoomReserved(room);
        return true;
    }

    @Override public boolean setRoomFree(Room room)
    {
        rooms.setRoomFree(room);
        return true;
    }

    @Override public boolean setUserInfo(User user)
    {
        users.setUserInfo(user);
        return true;
    }

    public User getUser(String username, String password) {
        try
        {
            return userDB.getUser(username,password);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return  null;
    }
}
