package entity;

public class CarInParking implements SdEntity {
    private int idParking;
    private int idCar;
    private String time;

    public CarInParking(int idParking, int idCar, String time) {
        this.idParking = idParking;
        this.idCar = idCar;
        this.time = time;
    }

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
