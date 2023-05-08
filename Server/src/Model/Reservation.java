package Model;
import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable
{
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;
    private User user;

    /// in the future we will have private User

    public Reservation(User user, Object startDate, Object endDate, Room room){
        if (startDate == null || endDate == null || room == null)
            throw new IllegalArgumentException();
        this.startDate = (LocalDate) startDate;
        this.endDate = (LocalDate) endDate;
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Room getRoom()
    {
        return room;
    }

    public String toString(){
        return "Reservation: " + "\n From: " + startDate + ", Until: " + endDate;
    }
}
