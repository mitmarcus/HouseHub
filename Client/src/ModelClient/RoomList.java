package ModelClient;

import java.util.ArrayList;

public class RoomList {
    private ArrayList<Room> list;

    public RoomList(){
        this.list = new ArrayList<>();
    }

    public void addRoom(Room room){
        list.add(room);
    }
    public void removeRoom(Room room){
        list.remove(room);
    }
    public ArrayList<Room> getAllRooms(){
        return list;
    }
}
