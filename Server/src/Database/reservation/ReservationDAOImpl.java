package Database.reservation;

import Database.DBconnection;
import Database.room.RoomDAO;
import Database.room.RoomDAOImpl;
import Database.user.UserDAO;
import Database.user.UserDAOImpl;
import Model.Reservation;
import Model.Room;
import Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    private static ReservationDAOImpl instance;
    private DBconnection dBconnection;
    private UserDAO userDAO;
    private RoomDAO roomDAO;

    public ReservationDAOImpl() throws SQLException {
        this.userDAO = new UserDAOImpl();
        this.roomDAO = new RoomDAOImpl();
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
        String query = "INSERT INTO reservation ( username, start_date, end_date,room_id) VALUES ( ?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, reservation.getUser().getUsername());
            statement.setDate(2, Date.valueOf(reservation.getStartDate()));
            statement.setDate(3, Date.valueOf(reservation.getEndDate()));
            statement.setString(4,reservation.getRoom().getRoomId());

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
        ArrayList<Reservation> reservations = new ArrayList<>();
        Connection connection = dBconnection.getConnection();
        String query = "SELECT * FROM reservation";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                String roomId = resultSet.getString("room_id");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                User user = userDAO.getUserByUsername(username);
                Room room = roomDAO.getRoomById(roomId);
                Reservation reservation = new Reservation(user,startDate,endDate,room);
                reservations.add(reservation);
            }
        }
        finally {
            dBconnection.disconnect();
        }
        return reservations;
    }

    @Override
    public void removeReservation(Reservation reservation) throws SQLException {

    }

    @Override
    public Reservation getReservationById(String id) throws SQLException {
        return null;
    }
}
