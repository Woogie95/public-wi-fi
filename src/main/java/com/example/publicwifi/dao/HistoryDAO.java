package com.example.publicwifi.dao;

import com.example.publicwifi.domain.History;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tjddnr12";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

//    public static void createHistory(History history) {
//        try (Connection connection = getConnection()) {
//            String insertQuery = "INSERT INTO history (id, latitude, longitude, register_date) VALUES (?,?, ?, ?)";
//            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
//                insertStatement.setLong(1, history.getId());
//                insertStatement.setDouble(2, history.getLatitude());
//                insertStatement.setDouble(3, history.getLongitude());
//                insertStatement.setObject(4, history.getRegisterDate());
//                insertStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<History> readAllHistories() {
//        List<History> histories = new ArrayList<>();
//
//        try (Connection connection = getConnection()) {
//            String selectQuery = "SELECT * FROM history";
//            try (Statement selectStatement = connection.createStatement(); ResultSet resultSet = selectStatement.executeQuery(selectQuery)) {
//                while (resultSet.next()) {
//                    Long id = resultSet.getLong("id");
//                    Double latitude = resultSet.getDouble("latitude");
//                    Double longitude = resultSet.getDouble("longitude");
//                    LocalDateTime registerDate = resultSet.getObject("register_date", LocalDateTime.class);
//                    History history = new History(id, latitude, longitude, registerDate);
//                    histories.add(history);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return histories;
//    }
//
//    public static void deleteHistory(Long id) {
//        try (Connection connection = getConnection()) {
//            String deleteQuery = "DELETE FROM history WHERE id = ?";
//            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
//                deleteStatement.setLong(1, id);
//                deleteStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
