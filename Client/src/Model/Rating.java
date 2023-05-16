package Model;

public class Rating {
  private int rating;

  private String username;
  private String room_id;

  public Rating(int rating, String username, String room_id)
  {
    this.rating = rating;
    this.username = username;
    this.room_id = room_id;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getUser() {
    return username;
  }

  public void setUser(User user) {
    this.username = username;
  }

  public String getRoom() {
    return room_id;
  }

  public void setRoom(Room room) {
    this.room_id = room_id;
  }
}
