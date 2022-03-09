package database.service;

import database.ConnectionManager;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDBService implements DataBaseService<User> {
    private static UserDBService INSTANCE;
    private static ConnectionManager db;


    public static UserDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        try {
            db.executeUpdate("INSERT INTO user (id, type, number, full_name, license, password) VALUES (" +
                    user.getId() + ", " + user.getType() + ", \"" + user.getNumber() + "\", \"" +
                    user.getFull_name() + "\", \"" + user.getLicense() + "\" , \"" + user.getPassword() + "\");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM user WHERE id=" + id + ";");
    }

    @Override
    public User getByID(Integer id) {
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM user WHERE id=" + id);
            rs.next();
            User user = getByResultSet(rs);
            rs.close();
            return user;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllFromDB() {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM user");
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
        List<User> list = getAllFromDB();
        System.out.println("Orders:");
        for (User item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public User getByResultSet(ResultSet rs) {
        try {
            return new User(
                    rs.getInt("id"),
                    rs.getInt("type"),
                    rs.getString("number"),
                    rs.getString("full_name"),
                    rs.getString("license"),
                    rs.getString("password")
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
