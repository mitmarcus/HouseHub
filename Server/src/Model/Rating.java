package Model;

public class Rating {
    private float rating;

    private User user;
    private Room room;

    public Rating(float rating, User user, Room room)
    {
        this.rating = rating;
        this.user = user;
        this.room = room;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
