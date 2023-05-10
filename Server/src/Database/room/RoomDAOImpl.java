package Database.room;

import Model.Room;
import Model.RoomList;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    private static RoomDAOImpl instance;
    RoomList list;

    private RoomDAOImpl() throws  SQLException{

    }

    public static RoomDAOImpl getInstance() throws SQLException {
        if (instance == null){
            instance = new RoomDAOImpl();
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
