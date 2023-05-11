package utility;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
         final  String url = "jdbc:postgresql://dumbo.db.elephantsql.com/jkmijtst";
         final  String username = "jkmijtst";
         final  String password = "9L2w3_NQTBeo0gJWOCyf04p-fbcUSGmS";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            insertDummyData(connection);


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
    public static void insertDummyData(Connection connection) throws SQLException {
        String query = "INSERT INTO users (first_name, last_name, username, password, phone_number) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "Nuri");
            statement.setString(2, "Hasan");
            statement.setString(3, "nuriSexyBoy");
            statement.setString(4, "password123");
            statement.setString(5, "12345678");

            int rowsAffected = statement.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) of dummy data.");
        }
    }
}
