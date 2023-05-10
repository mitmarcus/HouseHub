package Database.user;

import Database.room.RoomDAO;
import Model.User;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO  implements UserInterface{
    private  static UserDAO instance;
    private UserDAO() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static UserDAO getInstance() throws SQLException {
        if (instance == null){
            instance = new UserDAO();
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
