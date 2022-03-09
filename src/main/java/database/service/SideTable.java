package database.service;

import java.sql.ResultSet;
import java.util.List;

public interface SideTable<T> {

    void add(T obj);

//    void remove(Integer id);
//
//    void removeAll(Integer id);

    List<T> getAllFromDB();

    int getCount();

    T getByResultSet(ResultSet rs);
}
