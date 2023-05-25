package Database.user;

import Database.DBconnection;
import Model.Log.Log;
import Model.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    private DBconnection dbConnection;
    private static UserDAOImpl instance;

    /**
     * This constructor is used to create a user DAO
     *
     * @throws SQLException if the connection cannot be established
     */
    public UserDAOImpl() throws SQLException {
        this.dbConnection = DBconnection.getInstance();
    }

    /**
     * This method is used to get the instance of the user DAO
     *
     * @return the instance
     * @throws SQLException if the connection cannot be established
     */
    public static synchronized UserDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    /**
     * This method is used to add a user to the database
     *
     * @param user the user
     * @throws SQLException if the connection cannot be established
     */
    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "INSERT INTO users (first_name, last_name, username, password, phone_number) VALUES (? , ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhoneNumber());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
                Log.getInstance("User").addLog("User added successfully");
            } else {
                System.out.println("Failed to insert user.");
            }


        } finally {
            dbConnection.disconnect();
        }
    }

    /**
     * This method is used to get a user from the database
     *
     * @param username the username
     * @param password the password
     * @return the user
     * @throws SQLException if the connection cannot be established
     */
    @Override
    public User getUser(String username, String password) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User(resultSet.getString(3), resultSet.getString(4), resultSet.getString(1), resultSet.getString(2), resultSet.getString(5));
                Log.getInstance("User").addLog("User retrieved successfully : " + user.getUsername());
                return user;

            }
        } finally {
            connection.close();
        }
        return null;
    }

    /**
     * This method is used to get a user from the database
     *
     * @param username the username
     * @return the user
     * @throws SQLException if the connection cannot be established
     */
    @Override
    public User getUserByUsername(String username) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User(resultSet.getString(3), resultSet.getString(4), resultSet.getString(1), resultSet.getString(2), resultSet.getString(5));
                Log.getInstance("User").addLog("User retrieved successfully : "+ user.getUsername());
                return user;
            }
        }
        return null;
    }

    /**
     * This method is used to update a user's information in the database
     *
     * @param user the user
     * @throws SQLException if the connection cannot be established
     */
    public void setUserInfo(User user) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "UPDATE users SET first_name = ?, last_name = ?, password = ?, phone_number = ? WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getUsername());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User information updated successfully!");
                Log.getInstance("User").addLog("User information updated successfully : " + user.getUsername());
            } else {
                System.out.println("Failed to update user information.");
            }
        } finally {
            dbConnection.disconnect();
        }
    }

}
