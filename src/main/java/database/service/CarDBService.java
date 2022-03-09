package database.service;

import database.CarClass;
import database.ConnectionManager;
import entity.Car;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDBService implements DataBaseService<Car> {

    private static CarDBService INSTANCE;
    private static ConnectionManager db;


    public static CarDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CarDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Car car) {
        try {
            db.executeUpdate("INSERT INTO car (id, number, class, capacity, model, color) VALUES (" +
                    car.getId() + ", \"" + car.getNumber() + "\", " + car.getClasNum() + ", " +
                    car.getCapacity() + ", \"" + car.getModel() + "\" , \"" + car.getColor() + "\");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM car WHERE id=" + id + ";");
    }

    @Override
    public Car getByID(Integer id) {
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM car WHERE id=" + id);
            rs.next();
            Car car = getByResultSet(rs);
            rs.close();
            return car;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Car> getAllFromDB() {
        List<Car> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM car");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void viewDataBase() {
        List<Car> list = getAllFromDB();
        System.out.println("Orders:");
        for (Car item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Car getByResultSet(ResultSet rs) {
        try {
            return new Car(
                    rs.getInt("id"),
                    rs.getString("number"),
                    CarClass.values()[rs.getInt("class")],
                    rs.getInt("capacity"),
                    rs.getString("model"),
                    rs.getString("color")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }
}
