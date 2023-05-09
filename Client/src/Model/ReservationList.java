package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable {
    private ArrayList<Reservation> list;

    public ReservationList(){
        this.list= new ArrayList<>();
    }
    public void addReservation(Reservation reservation){
        for (Reservation reservation1 : list)
            if (reservation1.equals(reservation))
                throw new IllegalStateException();
        list.add(reservation);
    }
    public void removeReservation(Reservation reservation){
        reservation.getRoom().setReserved(false);
        list.remove(reservation);
    }
    public Reservation getReservationAtIndex(int index){
        return list.get(index);
    }
    public Reservation getReservationById(String id){
        for (Reservation reservation : list)
        {
            if (reservation.toString().equals(id))
                return reservation;
        }
        return null;
    }
    public ArrayList<Reservation> getAllReservations(){
        return list;
    }

    @Override
    public String toString() {
        return "Reservations: {"+ list +
                '}';
    }
}
