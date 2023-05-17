package Database.rating;

import Database.DBconnection;
import Database.room.RoomDAOImpl;
import Database.user.UserDAOImpl;
import Model.Rating;
import Model.Room;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingDAOImpl implements RatingDAO {
    private static RatingDAOImpl instance;
    private final DBconnection dbConnection;

    public RatingDAOImpl() throws SQLException {
        this.dbConnection = DBconnection.getInstance();
    }

    public static RatingDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new RatingDAOImpl();
        }
        return instance;
    }
    @Override
    public void addRating(Rating rating) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dbConnection.getConnection();
            System.out.println("Connection check on rating");
            String query = "INSERT INTO ratings (rating, room_id, username) VALUES (?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, rating.getRating());
            statement.setString(2, rating.getRoom().getRoomId());
            statement.setString(3, rating.getUser().getUsername());
            System.out.println("rating 1.." + rating);
            int rowsInserted = statement.executeUpdate();

            System.out.println("rating 2..." + rating);
            if (rowsInserted > 0) {
                System.out.println("Rating added successfully!");
            } else {
                System.out.println("Failed to add rating");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    public double getAvgRatingById(String id) throws SQLException {

        double avgRating = 0;
        Connection connection = dbConnection.getConnection();
        String query = "SELECT AVG(rating) AS average_value FROM rating WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                avgRating = resultSet.getDouble("average_value");
            }

        } finally {
            dbConnection.disconnect();
        }
        return avgRating;

    }


    @Override
    public int getRating() {
        return 0;
    }
}

