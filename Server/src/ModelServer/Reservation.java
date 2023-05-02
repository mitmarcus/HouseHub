package ModelServer;

import java.util.Date;

public class Reservation {
    private Date startDate;
    private Date endDate;
    private Room room;

    /// in the future we will have private User

    public Reservation(Date startDate, Date endDate, Room room){
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
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
