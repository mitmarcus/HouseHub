package Database;

import Model.Room;
import Model.User;

import java.sql.*;
import java.util.List;

public class DatabaseImpl implements DatabaseInterface{
    private Connection conn;
    private EmployeeService employeeService;
    private ProjectService projectService;
    private TaskService taskService;
    private DatabaseManager databaseManager;

    public DatabaseImpl(Connection conn) {
        connect();
        this.employeeService = new EmployeeService(conn);
        this.projectService = new ProjectService(conn);
        this.taskService = new TaskService(conn);
        this.databaseManager = new DatabaseManager(conn);
    }

    public void connect() {
        String url = "jdbc:postgresql://dumbo.db.elephantsql.com/jkmijtst";
        String username = "jkmijtst";
        String password = "9L2w3_NQTBeo0gJWOCyf04p-fbcUSGmS";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO users (username, password, first_name, last_name, phone_number) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.executeUpdate();
            System.out.println("User " + user.getUsername() + " added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding user " + user.getUsername() + ": " + e.getMessage());
        }
    }

    @Override
    public User getUser(String username) {
        User user = null;
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                System.out.println("User " + username + " found");
            } else {
                System.out.println("User " + username + " not found");
            }
        } catch (SQLException e) {
            System.out.println("Error getting user " + username + ": " + e.getMessage());
        }
        return user;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    /*@Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM room");
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setAnnouncement(resultSet.getString("announcement"));
                room.setPrice(resultSet.getString("price"));
                room.setAddress(resultSet.getString("address"));
                room.setNumberBedrooms(resultSet.getString("number_bedrooms"));
                room.setReserved(resultSet.getBoolean("reserved"));
                rooms.add(room);
            }
            System.out.println("All rooms retrieved successfully");
        } catch (SQLException e) {
            System.out.println("Error getting all rooms: " + e.getMessage());
        }
        return rooms;
    }*/

    @Override
    public void addRoom(Room room) {
        String sql = "INSERT INTO room (announcement, price, address, number_bedrooms, reserved) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getDb();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, room.getAnnouncement());
            pstmt.setString(2, room.getPrice());
            pstmt.setString(3, room.getAddress());
            pstmt.setString(4, room.getBedrooms());
            pstmt.setBoolean(5, room.isReserved());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new room has been added to the database.");
            }
        } catch (SQLException ex) {
            System.out.println("Error adding room to database: " + ex.getMessage());
        }
    }
    @Override
    public void deleteRoom(int roomId) {

    }

    @Override
    public void makeReservation(String username, int roomId, Date startDate, Date endDate) {

    }

    @Override
    public List<Room> getReservedRooms(String username) {
        return null;
    }

    @Override
    public List<Room> getAvailableRooms() {
        return null;
    }
}
