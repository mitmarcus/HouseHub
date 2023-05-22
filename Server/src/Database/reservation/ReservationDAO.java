package Database.reservation;

import Model.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO {
    void addReservation(Reservation reservation) throws SQLException;
    ArrayList<Reservation> getAllReservationsByUsername(String username) throws SQLException;
    void removeReservation(Reservation reservation) throws SQLException;
    Reservation getReservationById(String id) throws SQLException;
    void sendNotification(String owner,String tenant,String roomId)
        throws SQLException;

    ArrayList<String> getAllNotificationsByUsername(String username) throws SQLException;

    void removeNotification(String notification) throws SQLException;
}
