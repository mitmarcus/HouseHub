package ModelServer;

import java.util.ArrayList;
import java.util.Date;

public class ReservationList {
    private ArrayList<Reservation> list;

    public ReservationList(){
        this.list= new ArrayList<>();
    }
    public void addReservation(Date startDate, Date endDate, Room room){
        Reservation reservation = new Reservation(startDate, endDate, room);
        list.add(reservation);
    }
    public void removeReservation(Date startDate, Date endDate, Room room){
        Reservation reservation = new Reservation(startDate, endDate, room);
        list.remove(reservation);
    }
    @Override
    public String toString() {
        return "Reservations: {"+ list +
                '}';
    }
}
