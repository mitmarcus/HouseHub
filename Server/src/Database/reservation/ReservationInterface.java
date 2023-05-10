package Database.reservation;

import Model.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationInterface {
    void addReservation(Reservation reservation) throws SQLException;
    ArrayList<Reservation> getAllReservations() throws SQLException;
    void removeReservation(Reservation reservation) throws SQLException;
    Reservation getReservationById(String id) throws SQLException;
}
