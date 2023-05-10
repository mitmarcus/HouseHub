package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private final static String url = "jdbc:postgresql://dumbo.db.elephantsql.com/jkmijtst";
    private final static String username = "jkmijtst";
    private final static String password = "9L2w3_NQTBeo0gJWOCyf04p-fbcUSGmS";

    private static DBconnection instance;
    private static Connection conn;


    private DBconnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized DBconnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBconnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }
        return conn;
    }

    public void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        }
    }
}
