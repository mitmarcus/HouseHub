package Database;

import Model.Room;
import Model.User;

import java.sql.Date;
import java.util.List;

public interface DatabaseInterface {
    public void addUser(User user);

    public User getUser(String username);

    public List<Room> getAllRooms();

    public void addRoom(Room room);

    public void deleteRoom(int roomId);

    public void makeReservation(String username, int roomId, Date startDate, Date endDate);

    public List<Room> getReservedRooms(String username);

    public List<Room> getAvailableRooms();
}
