package database.service;

import database.ConnectionManager;
import entity.CarInParking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarInParkingDBService implements SideTable<CarInParking> {
    private static CarInParkingDBService INSTANCE;
    private static ConnectionManager db;


    public static CarInParkingDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CarInParkingDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(CarInParking carInParking) {
        try {
            db.executeUpdate("INSERT INTO car_in_parking (id_parking, id_car, setting_time) VALUES (" +
                    carInParking.getIdParking() + ", " + carInParking.getIdCar() + ", \"" + carInParking.getTime() + "\");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<CarInParking> getAllFromDB() {
        List<CarInParking> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM car_in_parking");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }

    @Override
    public CarInParking getByResultSet(ResultSet rs) {
        try {
            return new CarInParking(
                    rs.getInt("id_parking"),
                    rs.getInt("id_car"),
                    rs.getString("setting_time")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //    @Override
//    public void add(CarInParking carInParking) {
//        try {
//            db.executeUpdate("INSERT INTO car_in_parking (id_parking, id_car, setting_time) VALUES (" +
//                    carInParking.getIdParking() + ", " + carInParking.getIdCar() + ", \"" + carInParking.getTime() + "\");");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    @Override
//    public void removeByID(Integer id) {
//        db.executeUpdate("DELETE FROM car_in_parking WHERE id=" + id + ";");
//    }
//
//    @Override
//    public CarInParking getByID(Integer id) {
//        try {
//            ResultSet rs = db.executeSelect("SELECT * FROM car_in_parking WHERE id=" + id);
//            rs.next();
//            CarInParking carInParking = getByResultSet(rs);
//            rs.close();
//            return carInParking;
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<CarInParking> getAllFromDB() {
//        List<CarInParking> list = new ArrayList<>();
//        try {
//            ResultSet rs = db.executeSelect("SELECT * FROM car_in_parking");
//            while (rs.next())
//                list.add(getByResultSet(rs));
//            rs.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }
//
//    @Override
//    public void viewDataBase() {
//        List<CarInParking> list = getAllFromDB();
//        System.out.println("Orders:");
//        for (CarInParking item : list) {
//            System.out.println(item.toString());
//        }
//    }
//
//    @Override
//    public CarInParking getByResultSet(ResultSet rs) {
//        try {
//            return new CarInParking(
//                    rs.getInt("id_parking"),
//                    rs.getInt("id_car"),
//                    rs.getString("setting_time")
//            );
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return getAllFromDB().size();
//    }
}
