package Database.rating;

import Database.DBconnection;
import Model.Rating;

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


    public void addRating(Rating rating) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "INSERT INTO ratings (rating, room_id, username) VALUES (?,?,?) ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rating.getRating());
            statement.setString(2, rating.getUser());
            statement.setString(3, rating.getRoom());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Rating added successfully!");
            } else {
                System.out.println("Failed to add rating");
            }
        } finally {
            dbConnection.disconnect();
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

