package Database.room;

import Model.Room;

import java.util.ArrayList;

public interface RoomInterface {
    void addRoom(Room room);
    void removeRoom(Room room);
    Room getRoomByAnnouncement(String announcement);
    ArrayList<Room> getAllRooms();
}
