//package database;
//
//
//import repository.Car;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//
//public class CarRepository implements Repository<Car, Long> {
//
//
//    //private ConnectionManager connectionManager = ConnectionManager.getInstance();
//    private ConnectionManager connectionManager = ConnectionManager.getInstance();
//
//    public CarRepository() {};
//
//    public CarRepository(String DB_URL, String DB_USER, String DB_PASS) {
//        ConnectionManager.getInstance(DB_URL, DB_USER, DB_PASS);
//    }
//
//    private Extractor<Car> extractor = rs -> {
//        List<Car> carList = new ArrayList<>();
//        while (rs.next()) {
//            final Car car = new Car(
//                    rs.getInt("id"),
//                    rs.getString("number"),
//                    Clas.values()[rs.getInt("class")],
//                    rs.getInt("capacity"),
//                    rs.getString("model"),
//                    rs.getString("color")
//            );
//            carList.add(car);
//        }
//        return carList;
//    };
//
//    @Override
//    public List<Abonent> list() {
//        return executeSelect(QueryGenerator.getGenerator().generateSelect(), extractor);
//    }
//
//    @Override
//    public Abonent find(Long id) {
//        final List<Abonent> abonentList = executeSelect(String.format("SELECT * FROM PHONE.PHONEBOOK WHERE id = %d", id), extractor);
//        return abonentList.size() > 0 ? abonentList.get(0) : null;
//    }
//
//    @Override
//    public List<Abonent> search(Abonent pattern) {
//        return executeSelect(QueryGenerator.getGenerator().generateSearch(pattern), extractor);
//    }
//
//    @Override
//    public void insert(Abonent pattern) {
//        executeUpdate(QueryGenerator.getGenerator().generateInsert(pattern));
//    }
//
//    @Override
//    public void delete(Long ID) {
//        executeUpdate(QueryGenerator.getGenerator().generateDelete(ID));
//    }
//
//    @Override
//    public void update(Abonent pattern) {
//        executeUpdate(QueryGenerator.getGenerator().generateUpdate(pattern));
//    }
//
//    private <T> List<T> executeSelect(String query, Extractor<T> extractor) {
//        try (
//                Connection connection = connectionManager.getConnection();
//                Statement statement = connection.createStatement()
//        ) {
//            ResultSet resultSet = statement.executeQuery(query);
//            return extractor.extract(resultSet);
//        } catch (SQLException e) {
//            System.out.println("Unable to get data: " + e.getMessage());
//        }
//        return Collections.emptyList();
//    }
//
//    private void executeUpdate(String query) {
//        try (
//                Connection connection = connectionManager.getConnection();
//                Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate(query);
//        } catch (SQLException e) {
//            System.out.println("Unable to get data: " + e.getMessage());
//        }
//    }
//}