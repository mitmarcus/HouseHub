package Database.room;

import Database.DBconnection;
import Database.user.UserDAO;
import Database.user.UserDAOImpl;
import Model.Room;
import Model.RoomList;
import Model.User;

import javax.print.MultiDocPrintService;
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
        String query = "INSERT INTO room (owner, announcement, price, address, number_bedrooms, reserved, id,size) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,room.getOwner().getUsername());
            statement.setString(2, room.getAnnouncement());
            statement.setString(3, room.getPrice());
            statement.setString(4, room.getAddress());
            statement.setString(5, room.getBedrooms());
            statement.setBoolean(6, room.isReserved());
            statement.setString(7,room.getRoomId());
            statement.setString(8,room.getSize());

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
    public Room getRoomByAnnouncement(String announcement) throws SQLException
    {
        Room room = null;
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM room WHERE announcement = ?";

        try (PreparedStatement statement = connection.prepareStatement(query))
        {

            statement.setString(1, announcement);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String announcement1 = resultSet.getString("announcement");
                String price = resultSet.getString("price");
                String address = resultSet.getString("address");
                String size = resultSet.getString("size");
                String bedrooms = resultSet.getString("number_bedrooms");
                Boolean isReserved = resultSet.getBoolean("reserved");
                User user = UserDAOImpl.getInstance().getUserByUsername(resultSet.getString("owner"));

                System.out.println(user.toString());

                room = new Room(user, announcement1, price, address, size,
                    bedrooms, isReserved);
            }
        }
        finally
        {
            connection.close();
        }
        return room;
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

                User user = UserDAOImpl.getInstance().getUserByUsername(owner);
                Room room = new Room(user,announcement,price,address,size,numberBedrooms,reserved);

               return room;
            }
        } finally {
            dbConnection.disconnect();
        }
        return null;
    }

    @Override


    public ArrayList<Room> getAllRooms() throws SQLException
    {
        ArrayList<Room> list = new ArrayList<>();

        Connection connection = dbConnection.getConnection();
        String query ="SELECT * FROM room";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while   (resultSet.next())
            {
                String announcement = resultSet.getString("announcement");
                String price = resultSet.getString("price");
                String address = resultSet.getString("address");
                String size = resultSet.getString("size");
                String bedrooms = resultSet.getString("number_bedrooms");
                Boolean isReserved = resultSet.getBoolean("reserved");
                User user = UserDAOImpl.getInstance().getUserByUsername(resultSet.getString("owner"));

                Room room = new Room(user, announcement, price, address, size,
                    bedrooms, isReserved);
                list.add(room);
            }
        }
        finally
        {
            connection.close();
        }
        return list;
    }

    @Override
    public boolean setRoomReserved(Room room) throws SQLException {
        boolean setRoomReserved = false;
        String id = room.getRoomId();
        Connection connection = dbConnection.getConnection();
        String query ="UPDATE room SET reserved = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setBoolean(1,true);
            statement.setString(2,id);
            statement.executeUpdate();
            System.out.println("hello1");
            setRoomReserved=true;

        }
        finally
        {
            connection.close();
        }
        return setRoomReserved;
    }

    @Override
    public boolean setRoomFree(Room room) throws SQLException {
        return false;
    }
}
