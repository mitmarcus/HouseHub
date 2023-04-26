package ModelClient;

import java.util.Objects;

public class Room {
    private String announcement;
    private String price;
    private String address;
    private String size;
    private String bedrooms;

    public Room(String announcement,String price, String address, String size, String bedrooms) {
        this.announcement = announcement;
        this.price = price;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
    }
    public String getAnnouncement(){
        return announcement;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    @Override public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(announcement, room.announcement) && Objects.equals(price, room.price) &&
            Objects.equals(address, room.address) && Objects.equals(size, room.size) && Objects.equals(bedrooms, room.bedrooms);
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

