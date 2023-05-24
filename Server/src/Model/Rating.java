package Model;

import java.io.Serializable;

public class Rating implements Serializable {
    private int rating;

    private User user;
    private Room room;

    public Rating(int rating, User user, Room room) {
        this.rating = rating;
        this.user = user;
        this.room = room;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

}
