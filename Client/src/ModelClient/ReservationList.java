package ModelClient;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ReservationList {
    private ArrayList<Reservation> list;

    public ReservationList(){
        this.list= new ArrayList<>();
    }
    public void addReservation(LocalDate startDate, LocalDate endDate, Room room){
        Reservation reservation = new Reservation(startDate, endDate, room);
        list.add(reservation);
        room.setReserved(true);
    }
    public void removeReservation(LocalDate startDate, LocalDate endDate, Room room){
        Reservation reservation = new Reservation(startDate, endDate, room);
        list.remove(reservation);
        room.setReserved(false);
    }

    @Override
    public String toString() {
        return "Reservations: {"+ list +
                '}';
    }
}
