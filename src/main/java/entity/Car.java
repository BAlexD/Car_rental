package entity;

import database.CarClass;

public class Car implements Entity {
    private int id;
    private String number;
    private CarClass clas;
    private int capacity;
    private String model;
    private String color;

    public Car(int id, String number, CarClass clas, int capacity, String model, String color) {
        this.id = id;
        this.number = number;
        this.clas = clas;
        this.capacity = capacity;
        this.model = model;
        this.color = color;
    }

    public Car(int id, String number, int clas, int capacity, String model, String color) {
        this.id = id;
        this.number = number;
        this.clas = CarClass.toEnum(clas);
        this.capacity = capacity;
        this.model = model;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CarClass getClas() {
        return clas;
    }

    public int getClasNum(){
        return CarClass.toInt(clas);
    }

    public void setClas(CarClass clas) {
        this.clas = clas;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
