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
        String query = "INSERT INTO reservation (username,start_date,end_date,room_id,id) VALUES ( ?, ?, ?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, reservation.getUser().getUsername());
            statement.setDate(2, Date.valueOf(reservation.getStartDate()));
            statement.setDate(3, Date.valueOf(reservation.getEndDate()));
            statement.setString(4, reservation.getRoom().getRoomId());
            statement.setString(5,reservation.getId());

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
    public ArrayList<Reservation> getAllReservationsByUsername(String username) throws SQLException {
        ArrayList<Reservation> reservations = new ArrayList<>();
        Connection connection = dBconnection.getConnection();
        String query = "SELECT * FROM reservation where username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username1 = resultSet.getString("username");
                String roomId = resultSet.getString("room_id");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                User user = userDAO.getUserByUsername(username1);
                Room room = roomDAO.getRoomById(roomId);
                Reservation reservation = new Reservation(user, startDate, endDate, room);
                reservations.add(reservation);
            }
        } finally {
            dBconnection.disconnect();
        }
        return reservations;
    }

    @Override
    public void removeReservation(Reservation reservation) throws SQLException {
        Connection connection = dBconnection.getConnection();
        String query = "DELETE FROM reservation WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, reservation.getId());
            statement.executeUpdate();

        } finally {
            dBconnection.disconnect();
        }

    }

    @Override
    public Reservation getReservationById(String id) throws SQLException {
        Reservation reservation = null;
        Connection connection = dBconnection.getConnection();
        String query = "SELECT * FROM reservation WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username1 = resultSet.getString("username");
                String roomId = resultSet.getString("room_id");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                User user = userDAO.getUserByUsername(username1);
                Room room = roomDAO.getRoomById(roomId);
                Reservation other = new Reservation(user, startDate, endDate, room);
                reservation = other;
            }
        } finally {
            dBconnection.disconnect();
        }
        return reservation;
    }

    @Override public void sendNotification(String owner, String tenant,
        String roomId) throws SQLException
    {
        Connection connection = dBconnection.getConnection();
        String query = "INSERT INTO notifications (username,notification) VALUES ( ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, owner);
            statement.setString(2, "This user : " + tenant + " reserved room with id : " + roomId);

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
}
