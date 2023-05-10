package Database.room;

import Model.Room;
import Model.RoomList;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAO implements RoomInterface{
    private static RoomDAO instance;
    RoomList list;

    private RoomDAO() throws  SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static RoomDAO getInstance() throws SQLException {
        if (instance == null){
            instance = new RoomDAO();
        }
        return instance;
    }

    @Override
    public void addRoom(Room room) {

    }

    @Override
    public void removeRoom(Room room) {

    }

    @Override
    public Room getRoomByAnnouncement(String announcement) {
        return null;
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return null;
    }

    @Override
    public boolean setRoomReserved(Room room) throws SQLException {
        return false;
    }

    @Override
    public boolean setRoomFree(Room room) throws SQLException {
        return false;
    }
}
