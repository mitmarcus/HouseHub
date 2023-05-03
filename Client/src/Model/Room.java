package Model;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable
{
    private String announcement;
    private String price;
    private String address;
    private String size;
    private String bedrooms;
    private boolean isReserved;

    public Room(String announcement,String price, String address, String size, String bedrooms, boolean isReserved) {
        this.announcement = announcement;
        this.price = price;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
        this.isReserved = isReserved;
        if (announcement==null || price==(null) || address==(null) || size==(null) || bedrooms==(null))
            throw new NullPointerException();
    }
    public String getAnnouncement(){
        return announcement;
    }
    public String getPrice() {
       return price;
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
        return "Room{" +
                "price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", size='" + size + '\'' +
                ", bedrooms='" + bedrooms + '\'' +
                '}';
    }
}
