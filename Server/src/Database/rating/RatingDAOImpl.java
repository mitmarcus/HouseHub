package Database.rating;

import Database.DBconnection;
import Database.room.RoomDAOImpl;
import Model.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;

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
        String query = "INSERT INTO rating (rating, room_id, user) VALUES (?,?,?) ";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setFloat(1, rating.getRating());
            statement.setString(2, rating.getUser().getUsername());
            statement.setString(3, rating.getRoom().getRoomId());

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


    public float getRating() throws SQLException
    {
        // i know i have to make some weird ass thing from dbs which i dont know yet <3
        return 0;
    }
    }

