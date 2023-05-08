package Model;
import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable
{
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;

    /// in the future we will have private User

    public Reservation(User user,Object startDate, Object endDate, Room room){
        if (user == null|| startDate == null || endDate == null || room == null)
            throw new IllegalArgumentException();
        this.startDate = (LocalDate) startDate;
        this.endDate = (LocalDate) endDate;
        this.room = room;
        this.user = user;
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
