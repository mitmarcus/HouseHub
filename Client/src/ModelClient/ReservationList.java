package ModelClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ReservationList {
    private ArrayList<Reservation> list;

    public ReservationList(){
        this.list= new ArrayList<>();
    }
    public void addReservation(LocalDate startDate, LocalDate endDate){
        Reservation reservation = new Reservation(startDate, endDate);
        list.add(reservation);
    }
    public void removeReservation(LocalDate startDate, LocalDate endDate){
        Reservation reservation = new Reservation(startDate, endDate);
        list.remove(reservation);
    }

    @Override
    public String toString() {
        return "Reservations: {"+ list +
                '}';
    }
}
