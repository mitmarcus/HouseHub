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

    /**
     * This constructor is used to create a rating DAO
     *
     * @throws SQLException if the connection cannot be established
     */
    public RatingDAOImpl() throws SQLException {
        this.dbConnection = DBconnection.getInstance();
    }

    /**
     * This method is used to get the instance of the rating DAO
     *
     * @return the instance
     * @throws SQLException if the connection cannot be established
     */
    public static RatingDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new RatingDAOImpl();
        }
        return instance;
    }

    /**
     * This method is used to add a rating to the database
     *
     * @param rating the rating
     * @throws SQLException if the connection cannot be established
     */
    @Override
    public void addRating(Rating rating) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dbConnection.getConnection();

            String query = "INSERT INTO ratings (rating, room_id, username) VALUES (?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, rating.getRating());
            statement.setString(2, rating.getRoom().getRoomId());
            statement.setString(3, rating.getUser().getUsername());
            int rowsInserted = statement.executeUpdate();
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

    /**
     * This method is used to get the average rating of a room
     *
     * @param id the id of the room
     * @return the average rating
     * @throws SQLException if the connection cannot be established
     */
    public double getAvgRatingById(String id) throws SQLException {

        double avgRating = 0;
        Connection connection = dbConnection.getConnection();
        String query = "SELECT AVG(rating) AS average_rating FROM ratings WHERE room_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                avgRating = resultSet.getDouble("average_rating");
            }

        } finally {
            dbConnection.disconnect();
        }
        return avgRating;

    }

    /**
     * This method is used to get the initial rating
     *
     * @return the initial rating
     */
    @Override
    public int getRating() {
        return 0;
    }

    /**
     * This method is used to get if the user has rated a room
     *
     * @param roomId   the id of the room
     * @param username the username of the user
     * @return a boolean value if the user has rated the room
     * @throws SQLException if the connection cannot be established
     */
    @Override
    public boolean hasUserRated(String username, String roomId) throws SQLException {
        boolean hasrated = false;
        Connection connection = dbConnection.getConnection();
        String query = "SELECT COUNT(*) FROM ratings WHERE username = ? AND room_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, roomId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0)
                    hasrated = true;

            }
        } finally {
            dbConnection.disconnect();
        }

        return hasrated;
    }
}

