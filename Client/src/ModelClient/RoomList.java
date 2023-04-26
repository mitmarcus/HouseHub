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
    public Room getRoomAtIndex(int index)
    {
        return list.get(index);
    }
    public void addRoom(Room room){

            if (room.getAddress()!=null&&
            room.getBedrooms()!=null&&
            room.getSize()!=null&&
            room.getPrice()!=null)
                list.add(room);
            else
                throw new IllegalArgumentException();

    }
    public void removeRoom(Room room){
        list.remove(room);
    }
    public ArrayList<Room> getAllRooms(){
        return list;
    }
}
