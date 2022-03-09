package database.service;

import database.ConnectionManager;
import entity.Entity;

public class CommonDbService {
    private static CommonDbService INSTANCE;
    private static ConnectionManager db;

    public static CommonDbService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommonDbService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }


}
