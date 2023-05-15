package Database.rating;

import Model.Rating;

import java.sql.SQLException;

public interface RatingDAO {
    void addRating(Rating rating) throws SQLException;
    public float getRating() throws SQLException;
}
