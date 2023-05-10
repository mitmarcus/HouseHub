package Database;

import java.sql.*;

public class Postgres {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://dumbo.db.elephantsql.com/jkmijtst";
        String username = "jkmijtst";
        String password = "9L2w3_NQTBeo0gJWOCyf04p-fbcUSGmS";

        try {
            Connection db = DriverManager.getConnection(url, username, password);

            // Test the "users" table
            //testUsersTable(db);

            // Test the "room" table
            //testRoomTable(db);

            // Test the "reservation" table
            //testReservationTable(db);

            db.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    private static void testUsersTable(Connection db) throws SQLException {
//        Statement st = db.createStatement();
//
//        // Insert a new user
//        String insertQuery = "INSERT INTO users (username, password, first_name, last_name, phone_number) " +
//                "VALUES ('john123', 'password123', 'John', 'Doe', '12345678')";
//        st.executeUpdate(insertQuery);
//        System.out.println("New user inserted successfully.");
//
//        // Retrieve users
//        String selectQuery = "SELECT * FROM users";
//        ResultSet rs = st.executeQuery(selectQuery);
//        while (rs.next()) {
//            String username = rs.getString("username");
//            String firstName = rs.getString("first_name");
//            String lastName = rs.getString("last_name");
//            String phoneNumber = rs.getString("phone_number");
//            System.out.println("Username: " + username + ", First Name: " + firstName +
//                    ", Last Name: " + lastName + ", Phone Number: " + phoneNumber);
//        }
//        rs.close();
//
//        // Update a user's phone number
//        String updateQuery = "UPDATE users SET phone_number = '87654321' WHERE username = 'john123'";
//        st.executeUpdate(updateQuery);
//        System.out.println("User's phone number updated successfully.");
//
//        // Delete a user
//        String deleteQuery = "DELETE FROM users WHERE username = 'john123'";
//        st.executeUpdate(deleteQuery);
//        System.out.println("User deleted successfully.");
//
//        st.close();
//    }
//
//    private static void testRoomTable(Connection db) throws SQLException {
//        Statement st = db.createStatement();
//
//        // Insert a new room
//        String insertQuery = "INSERT INTO room (announcement, price, address, number_bedrooms, reserved) " +
//                "VALUES ('Spacious room for rent', '1000', '123 Main St', '3', false)";
//        st.executeUpdate(insertQuery);
//        System.out.println("New room inserted successfully.");
//
//        // Retrieve rooms
//        String selectQuery = "SELECT * FROM room";
//        ResultSet rs = st.executeQuery(selectQuery);
//        while (rs.next()) {
//            int roomId = rs.getInt("id");
//            String announcement = rs.getString("announcement");
//            String price = rs.getString("price");
//            String address = rs.getString("address");
//            String numBedrooms = rs.getString("number_bedrooms");
//            boolean reserved = rs.getBoolean("reserved");
//            System.out.println("Room ID: " + roomId + ", Announcement: " + announcement +
//                    ", Price: " + price + ", Address: " + address +
//                    ", Number of Bedrooms: " + numBedrooms + ", Reserved: " + reserved);
//        }rs.close();
//
//        // Update a room's price
//        String updateQuery = "UPDATE room SET price = '1200' WHERE id = 1";
//        st.executeUpdate(updateQuery);
//        System.out.println("Room price updated successfully.");
//
//        // Delete a room
//        String deleteQuery = "DELETE FROM room WHERE id = 1";
//        st.executeUpdate(deleteQuery);
//        System.out.println("Room deleted successfully.");
//
//        st.close();
//    }
//
//    private static void testReservationTable(Connection db) throws SQLException {
//        Statement st = db.createStatement();
//
//        // Insert a new reservation
//        String insertQuery = "INSERT INTO reservation (username, room_id, start_date, end_date) " +
//                "VALUES ('john123', 1, '2023-05-10', '2023-05-15')";
//        st.executeUpdate(insertQuery);
//        System.out.println("New reservation inserted successfully.");
//
//        // Retrieve reservations
//        String selectQuery = "SELECT * FROM reservation";
//        ResultSet rs = st.executeQuery(selectQuery);
//        while (rs.next()) {
//            int reservationId = rs.getInt("id");
//            String username = rs.getString("username");
//            int roomId = rs.getInt("room_id");
//            Date startDate = rs.getDate("start_date");
//            Date endDate = rs.getDate("end_date");
//            System.out.println("Reservation ID: " + reservationId + ", Username: " + username +
//                    ", Room ID: " + roomId + ", Start Date: " + startDate + ", End Date: " + endDate);
//        }
//        rs.close();
//
//        // Update a reservation's end date
//        String updateQuery = "UPDATE reservation SET end_date = '2023-05-20' WHERE id = 1";
//        st.executeUpdate(updateQuery);
//        System.out.println("Reservation end date updated successfully.");
//
//        // Delete a reservation
//        String deleteQuery = "DELETE FROM reservation WHERE id = 1";
//        st.executeUpdate(deleteQuery);
//        System.out.println("Reservation deleted successfully.");
//
//        st.close();
//    }
}
