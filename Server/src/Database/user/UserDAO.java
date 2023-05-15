package Database.user;

import Model.User;

import java.sql.SQLException;

public interface UserDAO {
    void addUser(User user) throws SQLException;
    User getUser(String username, String password) throws SQLException;
    User getUserByUsername(String username) throws SQLException;
}
