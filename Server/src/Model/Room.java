package Model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Room implements Serializable
{

    private String roomId;
    private String announcement;
    private String price;
    private String address;
    private String size;
    private String bedrooms;
    private boolean isReserved;
    private User owner;

    public Room(User owner,String announcement,String price, String address, String size, String bedrooms, boolean isReserved) {
        this.announcement = announcement;
        this.price = price;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
        this.isReserved = isReserved;
        this.owner = owner;
        this.roomId = generateID();
       // if (announcement==null || price==(null) || address==(null) || size==(null) || bedrooms==(null))
         //   throw new NullPointerException();
    }
    public String getAnnouncement(){
        return announcement;
    }
    public String getPrice() {
       return price;
    }
    public User getOwner(){
        return owner;
    }


    private String generateID(){
        if (announcement == null || address == null)
        {
            return null;
        }
        else {
            String an = announcement.substring(0, Math.min(announcement.length(), 5));
            String f = address.substring(0, Math.min(address.length(), 3));
            return an+f;
        }
    }
    public String getRoomId(){
        return roomId;
    }

    public void setPrice(String price) {
        if (price == null| price == "")
            throw  new IllegalArgumentException();
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address == "")
            throw new IllegalArgumentException();
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size==null|| size =="")
            throw new IllegalArgumentException();
        this.size = size;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        if (bedrooms == null|| bedrooms == "")
            throw new IllegalArgumentException();
        this.bedrooms = bedrooms;
    }

    @Override public boolean equals(Object o)
    {
        if (o==(null))
            throw new NullPointerException();
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(announcement, room.announcement) && Objects.equals(price, room.price) &&
            Objects.equals(address, room.address) && Objects.equals(size, room.size) && Objects.equals(bedrooms, room.bedrooms);
    }

    public boolean isReserved()
    {
        return isReserved;
    }

    public void setReserved(boolean reserved) //true or false
    {
        isReserved = reserved;
    }


    @Override
    public String toString() {
       return  "Room{" +
            "price='" + price + '\'' +
            ", address='" + address + '\'' +
            ", size='" + size + '\'' +
            ", bedrooms='" + bedrooms + '\'' + "isReserved" + isReserved +
            '}';
    }
}

