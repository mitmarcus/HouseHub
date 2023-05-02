package ModelServer;

import java.util.Date;

public class Reservation {
    private Date startDate;
    private Date endDate;

    /// in the future we will have private User

    public Reservation(Date startDate, Date endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public String toString(){
        return "Reservation: " + "\n From: " + startDate + ", Until: " + endDate;
    }
}
