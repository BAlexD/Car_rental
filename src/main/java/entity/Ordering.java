package entity;

public class Ordering implements Entity {
    private int id;
    private String number;
    private String begin;
    private String end;
    private int cost;
    private int id_user;

    public Ordering(int id, String number, String begin, String end, int cost, int id_user) {
        this.id = id;
        this.number = number;
        this.begin = begin;
        this.end = end;
        this.cost = cost;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
