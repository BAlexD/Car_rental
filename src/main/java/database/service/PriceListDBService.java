package database.service;

import database.ConnectionManager;
import entity.PriceList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceListDBService implements SideTable<PriceList> {
    private static PriceListDBService INSTANCE;
    private static ConnectionManager db;


    public static PriceListDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PriceListDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(PriceList obj) {
        try {
            db.executeUpdate("INSERT INTO price_list (class, price, date) VALUES (" +
                    obj.getClas() + ", " + obj.getPrice() + ", \"" + obj.getDate() + "\");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<PriceList> getAllFromDB() {
        List<PriceList> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM price_list");
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
    public PriceList getByResultSet(ResultSet rs) {
        try {
            return new PriceList(
                    rs.getInt("class"),
                    rs.getInt("price"),
                    rs.getString("date")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //    @Override
//    public void add(PriceList priceList) {
//        try {
//            db.executeUpdate("INSERT INTO price_list (class, price, date) VALUES (" +
//                    priceList.getClas() + ", " + priceList.getPrice() + ", \"" + priceList.getDate() + "\");");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    @Override
//    public void removeByID(Integer id) {
//        db.executeUpdate("DELETE FROM price_list WHERE id=" + id + ";");
//    }
//
//    @Override
//    public PriceList getByID(Integer id) {
//        try {
//            ResultSet rs = db.executeSelect("SELECT * FROM price_list WHERE id=" + id);
//            rs.next();
//            PriceList priceList = getByResultSet(rs);
//            rs.close();
//            return priceList;
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<PriceList> getAllFromDB() {
//        List<PriceList> list = new ArrayList<>();
//        try {
//            ResultSet rs = db.executeSelect("SELECT * FROM price_list");
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
//        List<PriceList> list = getAllFromDB();
//        System.out.println("Orders:");
//        for (PriceList item : list) {
//            System.out.println(item.toString());
//        }
//    }
//
//
//    @Override
//    public int getCount() {
//        return getAllFromDB().size();
//    }
}
