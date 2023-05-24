package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation implements Serializable {
    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;
    private User user;

    /**
     * This constructor is used to create a reservation
     *
     * @param user      the user
     * @param startDate the start date
     * @param endDate   the end date
     * @param room      the room
     */
    public Reservation(User user, Object startDate, Object endDate, Room room) {
        if (startDate == null || endDate == null || room == null)
            throw new IllegalArgumentException();
        this.startDate = (LocalDate) startDate;
        this.endDate = (LocalDate) endDate;
        this.room = room;
        this.user = user;
        this.id = generateId();
    }

    /**
     * This method is used to generate an ID for the reservation
     *
     * @return the ID
     */
    private String generateId() {
        String username = user.getUsername();
        String roomId = room.getRoomId();

        // Extract the first 3 letters of the username
        String usernamePrefix = username.substring(0, Math.min(username.length(), 3));
        String roomIdPrefix = roomId.substring(0,Math.min(roomId.length(),3));

        // Combine the username prefix and room ID
        String id = usernamePrefix + roomIdPrefix;

        return id;
    }

    /**
     * This method is used to get the ID
     *
     * @return the ID
     */
    public String getId() {
        return id;
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
     * This method is used to get the start date
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        // not safe to delete, used on the serer side
        return startDate;
    }

    /**
     * This method is used to get the end date
     *
     * @return the end date
     */
    public LocalDate getEndDate() {
        // not safe to delete, used on the serer side
        return endDate;
    }

    /**
     * This method is used to get the room
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * This method is used to compare two reservations
     *
     * @param o the other reservation
     */
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

    /**
     * This method is used to get the reservation in a string format
     *
     * @return the reservation in a string format
     */
    public String toString() {
        return "Reservation: " +"\n ID: " + id+ "\n From: " + startDate + ", Until: " + endDate;
    }
}
