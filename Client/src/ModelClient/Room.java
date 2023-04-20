package ModelClient;
public class Room {
    private String price;
    private String address;
    private int size;
    private int bedrooms;

    public Room(String price, String address, int size, int bedrooms) {
        this.price = price;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
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

