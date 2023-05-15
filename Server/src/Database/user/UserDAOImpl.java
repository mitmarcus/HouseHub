package Database.user;

import Database.DBconnection;
import Model.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO{
    private DBconnection dbConnection;
    private static UserDAOImpl instance;

    public UserDAOImpl() throws SQLException {
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
        String query = "INSERT INTO users (first_name, last_name, username, password, phone_number) VALUES (? , ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhoneNumber());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            } else {
                System.out.println("Failed to insert user.");
            }


        } finally {
            dbConnection.disconnect();
        }
    }

    @Override
    public User getUser(String username, String password) throws SQLException
    {
        Connection connection = dbConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                User user = new User(resultSet.getString(3),resultSet.getString(4),resultSet.getString(1),resultSet.getString(2),resultSet.getString(5));
                return user;
            }
        }
        finally
        {
            connection.close();
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) throws SQLException
    {
      Connection connection = dbConnection.getConnection();
      String query = "SELECT * FROM users WHERE username = ?";
      try (PreparedStatement statement = connection.prepareStatement(query))
      {
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next())
        {
          User user = new User(resultSet.getString(3),resultSet.getString(4),resultSet.getString(1),resultSet.getString(2),resultSet.getString(5));
          return user;
        }
      }
      return null;
    }
}
