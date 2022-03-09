package entity;

public class User implements Entity {
    private int id;
    private int type;
    private String number;
    private String full_name;
    private String license;
    private String password;

    public User(int id, int type, String number, String full_name, String license, String password) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.full_name = full_name;
        this.license = license;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
