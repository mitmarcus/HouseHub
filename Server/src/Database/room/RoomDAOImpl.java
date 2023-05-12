package Database.room;

import Database.DBconnection;
import Model.Room;
import Model.RoomList;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    private static RoomDAOImpl instance;
    private final DBconnection dbConnection;
    RoomList list;

    public RoomDAOImpl() throws  SQLException{
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
    public Room getRoomById(String id) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM room WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String owner = resultSet.getString("owner");
                String announcement = resultSet.getString("announcement");
                String price = resultSet.getString("price");
                String roomName = resultSet.getString("name");
                String address = resultSet.getString("address");
                String size = resultSet.getString("size");
                String numberBedrooms = resultSet.getString("number_bedrooms");
                boolean reserved = resultSet.getBoolean("reserved");

                Room room = new Room(announcement,price,address,size,numberBedrooms,reserved);

                return room;
            }
        } finally {
            dbConnection.disconnect();
        }
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
