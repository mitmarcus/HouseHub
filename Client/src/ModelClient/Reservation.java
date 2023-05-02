package ModelClient;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;

    /// in the future we will have private User

    public Reservation(Object startDate, Object endDate, Room room){
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
