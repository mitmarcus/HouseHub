package Database;

import model.*;

import java.sql.SQLException;

public interface DatabaseConnection {
    Employee login(UserProfile userProfile) throws SQLException;
}