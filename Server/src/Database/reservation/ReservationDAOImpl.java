package Database.reservation;

import Model.Reservation;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    private static ReservationDAOImpl instance;

    private ReservationDAOImpl() throws SQLException {

    }

    public static ReservationDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new ReservationDAOImpl();
        }
        return instance;
    }

    @Override
    public void addReservation(Reservation reservation) throws SQLException {

    }

    @Override
    public ArrayList<Reservation> getAllReservations() throws SQLException {
        return null;
    }

    @Override
    public void removeReservation(Reservation reservation) throws SQLException {

    }

    @Override
    public Reservation getReservationById(String id) throws SQLException {
        return null;
    }
}
