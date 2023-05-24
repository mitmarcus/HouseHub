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

    /**
     * This constructor is used to create a connection to the database
     *
     * @throws SQLException if the connection cannot be established
     */
    public DBconnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        conn = null;
    }

    /**
     * This method is used to get the instance of the connection
     *
     * @return the instance
     * @throws SQLException if the connection cannot be established
     */
    public static synchronized DBconnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBconnection();
        }
        return instance;
    }

    /**
     * This method is used to get the connection
     *
     * @return the connection
     * @throws SQLException if the connection cannot be established
     */
    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }

    /**
     * This method is used to disconnect from the database
     *
     * @throws SQLException if the connection cannot be established
     */
    public void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
