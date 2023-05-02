package ModelClient;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private LocalDate startDate;
    private LocalDate endDate;

    /// in the future we will have private User

    public Reservation(Object startDate, Object endDate){
        this.startDate = (LocalDate) startDate;
        this.endDate = (LocalDate) endDate;
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
