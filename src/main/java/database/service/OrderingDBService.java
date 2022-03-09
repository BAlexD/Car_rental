package database.service;

import database.ConnectionManager;
import entity.Ordering;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderingDBService implements DataBaseService<Ordering> {
    private static OrderingDBService INSTANCE;
    private static ConnectionManager db;


    public static OrderingDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderingDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Ordering ordering) {
        try {
            db.executeUpdate("INSERT INTO ordering (id, number, begin, end, cost, id_user) VALUES (" +
                    ordering.getId() + ", " + ordering.getNumber() + ", \"" + ordering.getBegin() + "\", \"" +
                    ordering.getEnd() + "\", \"" + ordering.getCost() + "\" , " + ordering.getId_user() + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM ordering WHERE id=" + id + ";");
    }

    @Override
    public Ordering getByID(Integer id) {
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM ordering WHERE id=" + id);
            rs.next();
            Ordering ordering = getByResultSet(rs);
            rs.close();
            return ordering;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ordering> getAllFromDB() {
        List<Ordering> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM ordering");
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
        List<Ordering> list = getAllFromDB();
        System.out.println("Orders:");
        for (Ordering item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Ordering getByResultSet(ResultSet rs) {
        try {
            return new Ordering(
                    rs.getInt("id"),
                    rs.getString("number"),
                    rs.getString("begin"),
                    rs.getString("end"),
                    rs.getInt("cost"),
                    rs.getInt("id_user")
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
