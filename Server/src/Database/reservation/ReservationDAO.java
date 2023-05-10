package Database.reservation;

import Database.user.UserDAO;
import Model.Reservation;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAO implements ReservationInterface {
    private static ReservationDAO instance;

    private ReservationDAO() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static ReservationDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new ReservationDAO();
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
