package entity;

import database.CarClass;
import tool.DateConverter;

public class PriceList implements SdEntity {
    private int clas;
    private int price;
    private String date;

    public PriceList(int clas, int price, String date) {
        this.clas = clas;
        this.price = price;
        this.date = checkDate(date);
    }

    public PriceList(CarClass clas, int price, String date) {
        this.clas = CarClass.toInt(clas);
        this.price = price;
        this.date = checkDate(date);
    }

    private String checkDate(String str) {
        try {
            return DateConverter.getInstance().fromString(str).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
