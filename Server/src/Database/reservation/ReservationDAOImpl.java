package Database.reservation;

import Database.DBconnection;
import Model.Reservation;

import java.sql.*;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    private static ReservationDAOImpl instance;
    private DBconnection dBconnection;

    private ReservationDAOImpl() throws SQLException {
        this.dBconnection = DBconnection.getInstance();
    }

    public static synchronized ReservationDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new ReservationDAOImpl();
        }
        return instance;
    }

    @Override
    public void addReservation(Reservation reservation) throws SQLException {
        Connection connection = dBconnection.getConnection();
        String query = "INSERT INTO reservation ( username, start_date, end_date) VALUES ( ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, reservation.getUser().getUsername());
            statement.setDate(2, Date.valueOf(reservation.getStartDate()));
            statement.setDate(3, Date.valueOf(reservation.getEndDate()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Reservation inserted successfully!");
            } else {
                System.out.println("Failed to insert reservation.");
            }


        } finally {
            dBconnection.disconnect();
        }
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
