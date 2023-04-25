package ModelClient;

import java.util.ArrayList;

public class RoomList {
    private ArrayList<Room> list;

    public RoomList(){
        this.list = new ArrayList<>();
    }

    public Room getRoomByAnnouncement(String announcement){
        for (int i =0; i< list.size(); i++){
            if (list.get(i).getAnnouncement().equals(announcement)){
                return list.get(i);
            }
        }
        return null;
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