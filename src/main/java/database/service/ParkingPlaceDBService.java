package database.service;

import database.ConnectionManager;
import entity.ParkingPlace;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingPlaceDBService implements DataBaseService<ParkingPlace> {
    private static ParkingPlaceDBService INSTANCE;
    private static ConnectionManager db;


    public static ParkingPlaceDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParkingPlaceDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(ParkingPlace parkingPlace) {
        try {
            db.executeUpdate("INSERT INTO parking_place (id, address) VALUES (" +
                    parkingPlace.getId() + ", \"" + parkingPlace.getAddress() + "\");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM parking_place WHERE id=" + id + ";");
    }

    @Override
    public ParkingPlace getByID(Integer id) {
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM parking_place WHERE id=" + id);
            rs.next();
            ParkingPlace parkingPlace = getByResultSet(rs);
            rs.close();
            return parkingPlace;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ParkingPlace> getAllFromDB() {
        List<ParkingPlace> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM parking_place");
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
        List<ParkingPlace> list = getAllFromDB();
        System.out.println("Orders:");
        for (ParkingPlace item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public ParkingPlace getByResultSet(ResultSet rs) {
        try {
            return new ParkingPlace(
                    rs.getInt("id"),
                    rs.getString("address")
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
