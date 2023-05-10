package Database.user;

import Model.User;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    private  static UserDAOImpl instance;
    private UserDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static UserDAOImpl getInstance() throws SQLException {
        if (instance == null){
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {

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
