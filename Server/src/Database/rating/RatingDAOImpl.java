package Database.rating;

import Database.DBconnection;
import Model.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RatingDAOImpl implements RatingDAO
{
    private static RatingDAOImpl instance;
    private final DBconnection dbConnection;

    public RatingDAOImpl() throws SQLException {
        this.dbConnection = DBconnection.getInstance();
    }

    public static RatingDAOImpl getInstance() throws SQLException {
        if (instance == null){
            instance = new RatingDAOImpl();
        }
        return instance;
    }


    public void addRating(Rating rating) throws SQLException {
        Connection connection = dbConnection.getConnection();
        String query = "INSERT INTO rating (rating, room_id, username) VALUES (?,?,?) ";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setFloat(1, rating.getRating());
            statement.setString(2, rating.getUser());
            statement.setString(3, rating.getRoom());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Rating added successfully!");
            } else {
                System.out.println("Failed to add rating");
            }
        }  finally {
                dbConnection.disconnect();
            }
        }


    public int getRating() throws SQLException
    {
        // i know i have to make some weird ass thing from dbs which i dont know yet <3
        return 0;
    }
    }

