package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    public DatabaseManager() {

    }


    public void addDummyData() throws SQLException {
        //addDummyDataUsers();
        //addDummyDataRooms();
        //addDummyDataReservations();
    }
    public void clearAllTables() throws SQLException {
        String query = "DELETE FROM users cascade; DELETE FROM room cascade; DELETE FROM reservation cascade;";
        PreparedStatement st = conn.prepareStatement(query);
        st.executeUpdate();
    }
}