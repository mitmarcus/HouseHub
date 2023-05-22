package Model;

import Database.rating.RatingDAO;
import Database.rating.RatingDAOImpl;
import Database.reservation.ReservationDAO;

import Database.reservation.ReservationDAOImpl;

import Database.room.RoomDAO;

import Database.room.RoomDAOImpl;
import Database.user.UserDAO;
import Database.user.UserDAOImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelManagerServer implements ModelServer {
    private UserDAO userDB;

    private ReservationDAO reservationDAO;

    private RoomDAO roomDB;

    private RatingDAO ratingDB;


    public ModelManagerServer() {
        try {
            this.reservationDAO = ReservationDAOImpl.getInstance();
            this.userDB = UserDAOImpl.getInstance();
            this.roomDB = RoomDAOImpl.getInstance();
            this.ratingDB = RatingDAOImpl.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addRoom(Room room) {
        try {
            roomDB.addRoom(room);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void removeRoom(Room room) {

        for (String path : getRoomImagesPaths(room.getRoomId()))
        {
            System.out.println(path);
            File file = new File(path);
            file.delete();
        }

        try
        {

            roomDB.removeRoom(room);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }

    }

    @Override
    public Room getRoomByAnnouncement(String announcement) {
        try {
            return roomDB.getRoomByAnnouncement(announcement);
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        try {
            return roomDB.getAllRooms();
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void addReservation(Reservation reservation) {
        try {
            reservationDAO.addReservation(reservation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Reservation> getAllReservationsByUsername(String username) {
        try {
            return reservationDAO.getAllReservationsByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeReservation(Reservation reservation) {
        try {
            reservationDAO.removeReservation(reservation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        try {
            userDB.addUser(user);

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            return userDB.getUserByUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Reservation getReservationById(String id) {

        try {
            return reservationDAO.getReservationById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setRoomReserved(Room room) throws RemoteException {

        try {
            return roomDB.setRoomReserved(room);
        } catch (SQLException e) {
            e.getMessage();
        }
        return true;
    }

    @Override
    public boolean setRoomFree(Room room) {
        try {
            return roomDB.setRoomFree(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void sendFile(String roomId,String name, byte[] img) {
        File folder = new File("Server/src/Images/");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File outFile = new File(folder.getFreeSpace() + name);
        try {
            String imagePath = "Server/src/Images/" + outFile;
            FileOutputStream fos = new FileOutputStream(imagePath, false);
            byte[] reciveimg = new byte[img.length];
            for (int i = 0; i < img.length; i++) {
                reciveimg[i] = img[i];
            }
            fos.write(reciveimg);
            fos.close();
            roomDB.addImagePath(roomId, imagePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override public boolean setUserInfo(User user){
        try {
            userDB.setUserInfo(user);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public ArrayList<Room> getRoomsByUsername(String username)
    {
        try
        {
            return  roomDB.getRoomsByUsername(username);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override public Room getRoomById(String Id)
    {
        try
        {
            return roomDB.getRoomById(Id);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return null;
    }


    @Override public ArrayList<String> getRoomImagesPaths(String roomId)
    {
        try
        {
            return roomDB.getRoomImagesPaths(roomId);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return null;
    }

        @Override public void addRating(Rating rating)
    {
        try {
            ratingDB.addRating(rating);
        }
        catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public boolean hasUserRated(String username, String roomId) {
        try {
            return ratingDB.hasUserRated(username, roomId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public double getAvgRatingById(String id) {
        try
        {
            return ratingDB.getAvgRatingById(id);
        }
        catch (SQLException e)
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
            reservationDAO.sendNotification(owner,tenant,roomId);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }

    @Override public void deletePictures(String roomId)
    {
        System.out.println(roomId);
        System.out.println(getRoomImagesPaths(roomId));



    }

    @Override
    public ArrayList<String> getAllNotificationsByUsername(String username) {
        try {
            return reservationDAO.getAllNotificationsByUsername(username);
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override public void removeNotification(String notification)
    {
        try
        {
            reservationDAO.removeNotification(notification);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public User getUser(String username, String password) {
        try
        {
            return userDB.getUser(username,password);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return null;
    }
}
