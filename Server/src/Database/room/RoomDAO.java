package Database.room;

import Model.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomDAO {
    void addRoom(Room room) throws SQLException;
    void removeRoom(Room room) throws SQLException;
    Room getRoomByAnnouncement(String announcement) throws SQLException;
    Room getRoomById(String id) throws SQLException;
    ArrayList<Room> getAllRooms() throws SQLException;
    boolean setRoomReserved(Room room) throws SQLException;
    boolean setRoomFree(Room room) throws SQLException;
}
