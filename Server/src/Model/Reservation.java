package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Reservation implements Serializable {
    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;
    private User user;

    public Reservation(User user, Object startDate, Object endDate, Room room) {
        if (startDate == null || endDate == null || room == null)
            throw new IllegalArgumentException();
        this.startDate = (LocalDate) startDate;
        this.endDate = (LocalDate) endDate;
        this.room = room;
        this.user = user;
        this.id = generateId();
    }

    private String generateId() {
        String username = user.getUsername();
        String roomId = room.getRoomId();

        // Extract the first 3 letters of the username
        String usernamePrefix = username.substring(0, Math.min(username.length(), 3));
        String roomIdPrefix = roomId.substring(0, Math.min(roomId.length(), 3));

        // Combine the username prefix and room ID
        String id = usernamePrefix + roomIdPrefix;

        return id;
    }

    public String getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reservation reservation)) return false;
        return Objects.equals(user, reservation.user) && Objects.equals(startDate, reservation.startDate) &&
                Objects.equals(endDate, reservation.endDate) && Objects.equals(room, (reservation.room));
    }

    public String toString() {
        return "Reservation: " + "\n ID: " + id + "\n From: " + startDate + ", Until: " + endDate;
    }
}
