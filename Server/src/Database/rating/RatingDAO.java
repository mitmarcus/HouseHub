
package Database.rating;

import Model.Rating;

import java.sql.SQLException;

public interface RatingDAO {
    void addRating(Rating rating) throws SQLException;
    double getAvgRatingById(String id) throws SQLException;
    int getRating() throws SQLException;
    boolean hasUserRated(String username, String roomId) throws SQLException;
}

