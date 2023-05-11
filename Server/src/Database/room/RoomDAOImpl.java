package Database.room;

import Database.DBconnection;
import Model.Room;
import Model.RoomList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    private static RoomDAOImpl instance;
    private final DBconnection dbConnection;
    RoomList list;

    private RoomDAOImpl() throws  SQLException{
        this.dbConnection = DBconnection.getInstance();
    }

    public static RoomDAOImpl getInstance() throws SQLException {
        if (instance == null){
            instance = new RoomDAOImpl();
        }
        return instance;
    }

    @Override
    public void addRoom(Room room) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "INSERT INTO room (announcement, price, address, number_bedrooms, reserved) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, room.getAnnouncement());
            statement.setString(2, room.getPrice());
            statement.setString(3, room.getAddress());
            statement.setString(4, room.getBedrooms());
            statement.setBoolean(5, room.isReserved());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Room added successfully!");
            } else {
                System.out.println("Failed to add room.");
            }
        } finally {
            dbConnection.disconnect();
        }
    }

    @Override
    public void removeRoom(Room room) throws SQLException {
//        Connection connection = dbConnection.getConnection();
//        String query = "DELETE FROM house_hub.room WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, room.getId());
//
//            int rowsDeleted = statement.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("Room removed successfully!");
//            } else {
//                System.out.println("Failed to remove room.");
//            }
//        } finally {
//            dbConnection.disconnect();
//        }

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
