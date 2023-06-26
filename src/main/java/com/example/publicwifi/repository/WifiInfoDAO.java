//package com.example.publicwifi.repository;
//
//import com.example.publicwifi.domain.WifiInfo;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class WifiInfoDAO {
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "tjddnr12";
//
//    public void saveWifiInfo(WifiInfo wifiInfo) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//            String query = "INSERT INTO wifi_info VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setString(1, wifiInfo.getMgrNo());
//            preparedStatement.setString(2, wifiInfo.getWrdofc());
//            preparedStatement.setString(3, wifiInfo.getMainNm());
//            preparedStatement.setString(4, wifiInfo.getAddress1());
//            preparedStatement.setString(5, wifiInfo.getAddress2());
//            preparedStatement.setString(6, wifiInfo.getInstlFloor());
//            preparedStatement.setString(7, wifiInfo.getInstlTy());
//            preparedStatement.setString(8, wifiInfo.getInstlMby());
//            preparedStatement.setString(9, wifiInfo.getSvcSe());
//            preparedStatement.setString(10, wifiInfo.getCmcwr());
//            preparedStatement.setString(11, wifiInfo.getCnstcYear());
//            preparedStatement.setString(12, wifiInfo.getInoutDoor());
//            preparedStatement.setString(13, wifiInfo.getRemars3());
//            preparedStatement.setString(14, wifiInfo.getLat());
//            preparedStatement.setString(15, wifiInfo.getLnt());
//            preparedStatement.setString(16, wifiInfo.getWorkDttm());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}