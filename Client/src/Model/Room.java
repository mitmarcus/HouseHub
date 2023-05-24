package Model;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable {
    private String roomId;
    private String announcement;
    private String price;
    private String address;
    private String size;
    private String bedrooms;
    private boolean isReserved;
    private User owner;

    /**
     * This constructor is used to create a room
     *
     * @param owner        the owner
     * @param announcement the announcement
     * @param price        the price
     * @param address      the address
     * @param size         the size
     * @param bedrooms     the bedrooms
     * @param isReserved   the isReserved
     */
    public Room(User owner, String announcement, String price, String address, String size, String bedrooms, boolean isReserved) {
        this.announcement = announcement;
        this.price = price;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
        this.isReserved = isReserved;
        this.owner = owner;
        this.roomId = generateID();
    }

    /**
     * This method is used to get the announcement
     *
     * @return the announcement
     */
    public String getAnnouncement() {
        return announcement;
    }

    /**
     * This method is used to get the price
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method is used to get the Owner
     *
     * @return the address
     */
    public User getOwner() {
        return owner;
    }

    /**
     * This method is used to generate the room ID by combining the first 5 letters of the announcement and the first 3 letters of the address
     *
     * @return the ID
     */
    private String generateID() {
        if (announcement == null || address == null) {
            return null;
        } else {
            String an = announcement.substring(0, Math.min(announcement.length(), 5));
            String f = address.substring(0, Math.min(address.length(), 3));
            return an + f;
        }
    }

    /**
     * This method is used to get the room ID
     *
     * @return the room ID
     */
    public String getRoomId() {
        System.out.println(announcement);
        return roomId;
    }

    /**
     * This method is used to set the price
     *
     * @param price
     */
    public void setPrice(String price) {
        if (price == null | price == "")
            throw new IllegalArgumentException();
        this.price = price;
    }

    /**
     * This method is used to get the address
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method is used to set the address
     *
     * @param address the address
     */
    public void setAddress(String address) {
        if (address == null || address == "")
            throw new IllegalArgumentException();
        this.address = address;
    }

    /**
     * This method is used to get the size
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * This method is used to set the size
     *
     * @param size the size
     */
    public void setSize(String size) {
        if (size == null || size == "")
            throw new IllegalArgumentException();
        this.size = size;
    }

    /**
     * This method is used to get the bedrooms
     *
     * @return the bedrooms
     */
    public String getBedrooms() {
        return bedrooms;
    }

    /**
     * This method is used to set the bedrooms
     *
     * @param bedrooms the bedrooms
     */
    public void setBedrooms(String bedrooms) {
        if (bedrooms == null || bedrooms == "")
            throw new IllegalArgumentException();
        this.bedrooms = bedrooms;
    }

    /**
     * This method is used to check if two users are equal
     *
     * @param o the object to compare with
     * @return true if the given object is equal to this user
     */
    @Override
    public boolean equals(Object o) {
        if (o == (null))
            throw new NullPointerException();
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(announcement, room.announcement) && Objects.equals(price, room.price) &&
                Objects.equals(address, room.address) && Objects.equals(size, room.size) && Objects.equals(bedrooms, room.bedrooms);
    }

    /**
     * This method is used to get the isReserved
     *
     * @return the isReserved
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * This method is used to set the isReserved
     *
     * @param reserved the isReserved
     */
    public void setReserved(boolean reserved) //true or false
    {
        // not safe to delete, used on server side
        isReserved = reserved;
    }

    /**
     * This method is used to get the string representation of the room
     *
     * @return the string representation of the room
     */
    @Override
    public String toString() {
        return "Room{" +
                "price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", size='" + size + '\'' +
                ", bedrooms='" + bedrooms + '\'' + "isReserved" + isReserved +
                '}';
    }
}

