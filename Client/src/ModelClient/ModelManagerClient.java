package ModelClient;

import java.util.ArrayList;

public class ModelManagerClient implements ModelClient
{
    private RoomList list;

    @Override
    public void addRoom(Room room) {
        list.addRoom(room);
    }

    @Override
    public void removeRoom(Room room) {
        list.removeRoom(room);
    }

    @Override
    public Room getRoomByAnnouncement(String announcement) {
        return list.getRoomByAnnouncement(announcement);
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return list.getAllRooms();
    }

}
