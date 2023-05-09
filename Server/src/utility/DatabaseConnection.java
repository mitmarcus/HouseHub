package utility;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/house_hub";
        final String username = "postgres";
        final String password = "331425";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");

        } catch (SQLException e) {
            System.out.println("error");
           e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("error with closing");
                e.printStackTrace();
            }
            System.out.println("closed");
        }
    }
}
