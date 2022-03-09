package entity;

public class ParkingPlace implements Entity {
    private int id;
    private String address;

    public ParkingPlace(int id, String adress) {
        this.id = id;
        this.address = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
