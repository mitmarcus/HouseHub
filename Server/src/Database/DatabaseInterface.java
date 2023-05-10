package Database;

import Model.Room;
import Model.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    void addUser(User user) throws SQLException;

    User getUser(String username) throws SQLException;

    List<Room> getAllRooms() throws SQLException;

    void addRoom(Room room) throws SQLException;

    void deleteRoom(int roomId) throws SQLException;

    void makeReservation(String username, int roomId, Date startDate, Date endDate) throws SQLException;

    List<Room> getReservedRooms(String username) throws SQLException;

    List<Room> getAvailableRooms() throws SQLException;
}
