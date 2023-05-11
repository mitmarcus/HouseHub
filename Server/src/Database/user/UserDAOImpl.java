package Database.user;

import Database.DBconnection;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    private DBconnection dbConnection;
    private static UserDAOImpl instance;

    private UserDAOImpl() throws SQLException {
        this.dbConnection = DBconnection.getInstance();
    }

    public static synchronized UserDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {

            String query = "INSERT INTO users (first_name, last_name, username, password, phone_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhoneNumber());
            System.out.println(user.getUsername());
            System.out.println(query);
            statement.executeUpdate(query);

        } finally {
            dbConnection.disconnect();
        }
    }

    @Override
    public User getUser(String username, String password) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void removeUserByUsername(String username) {

    }

    @Override
    public void removeUserByPhoneNumber(String phoneNumber) {

    }
}
