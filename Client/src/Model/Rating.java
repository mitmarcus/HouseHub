package Model;

import java.io.Serializable;

public class Rating implements Serializable {
    private int rating;
    private User user;
    private Room room;

    /**
     * This constructor is used to create a rating
     *
     * @param rating the rating
     * @param user   the user
     * @param room   the room
     */
    public Rating(int rating, User user, Room room) {
        this.rating = rating;
        this.user = user;
        this.room = room;
    }

    /**
     * This method is used to get the rating
     *
     * @return the rating
     */
    public int getRating() {
        // not safe to delete, used on the serer side
        return rating;
    }

    /**
     * This method is used to set the rating
     *
     * @param rating the rating
     */
    public void setRating(int rating) {
        // not safe to delete, used on the serer side
        this.rating = rating;
    }

    /**
     * This method is used to get the user
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * This method is used to get the room
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }
}
