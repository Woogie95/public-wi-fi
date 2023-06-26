//package com.example.publicwifi.repository;
//
//import com.example.publicwifi.domain.History;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class HistoryDAO {
//
//    private String jdbcURL = "jdbc:mysql://localhost/project?serverTimezone=UTC";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "tjddnr12";
//
//    private static final String INSERT_history_SQL = "INSERT INTO history" + "  (id, lat, lnt, registerDate) VALUES " +
//            " (?, ?, ?,?);";
//
//    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
//    private static final String SELECT_ALL_USERS = "select * from users";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
//
//    public HistoryDAO() {
//
//    }
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException | ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public void createHistory(History history) {
//        try (Connection connection = getConnection()) {
//            String insertQuery = "INSERT INTO history (id, latitude, longitude, register_date) VALUES (?,?, ?, ?)";
//            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
//                insertStatement.setLong(1, history.getId());
//                insertStatement.setDouble(2, history.getLat());
//                insertStatement.setDouble(3, history.getLnt());
//                insertStatement.setObject(4, history.getRegisterDate());
//                insertStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
////    public static List<History> readAllHistories() {
////        List<History> histories = new ArrayList<>();
////
////        try (Connection connection = getConnection()) {
////            String selectQuery = "SELECT * FROM history";
////            try (Statement selectStatement = connection.createStatement(); ResultSet resultSet = selectStatement.executeQuery(selectQuery)) {
////                while (resultSet.next()) {
////                    Long id = resultSet.getLong("id");
////                    Double latitude = resultSet.getDouble("latitude");
////                    Double longitude = resultSet.getDouble("longitude");
////                    LocalDateTime registerDate = resultSet.getObject("register_date", LocalDateTime.class);
////                    History history = new History(id, latitude, longitude, registerDate);
////                    histories.add(history);
////                }
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////        return histories;
////    }
////
////    public static void deleteHistory(Long id) {
////        try (Connection connection = getConnection()) {
////            String deleteQuery = "DELETE FROM history WHERE id = ?";
////            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
////                deleteStatement.setLong(1, id);
////                deleteStatement.executeUpdate();
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
//}
