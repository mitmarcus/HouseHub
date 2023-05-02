package ModelClient;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private DatePicker startDate;
    private DatePicker endDate;

    /// in the future we will have private User

    public Reservation(DatePicker startDate, DatePicker endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String toString(){
        return "Reservation: " + "\n From: " + startDate + ", Until: " + endDate;
    }
}
