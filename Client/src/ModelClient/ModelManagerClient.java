package ModelClient;

import java.util.ArrayList;

public class ModelManagerClient implements ModelClient
{
    private RoomList list;

    public ModelManagerClient ()
    {
        this.list = new RoomList();
        this.list.addRoom(new Room("Room next Lovbjerg.",null, "123 Main St", "200", "3"));
        this.list.addRoom(new Room("Apartment for 2, next to VIA","$500,000", "456 Elm St", "300", "2"));
        this.list.addRoom(new Room("Available room close to city center","$700,000", "789 Oak St", "120", "1"));
    }

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
