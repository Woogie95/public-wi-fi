package com.example.publicwifi.repository;

import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.util.DBManager;

import java.sql.*;

import static com.example.publicwifi.util.DBManager.getConnection;

public class WifiInfoRepository {

    // 등록
    public void saveWifiInfo(WifiInfo wifiInfo) {
        String query = "INSERT INTO wifi_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, wifiInfo.getMgrNo());
            preparedStatement.setString(2, wifiInfo.getWrdofc());
            preparedStatement.setString(3, wifiInfo.getMainNm());
            preparedStatement.setString(4, wifiInfo.getAddress1());
            preparedStatement.setString(5, wifiInfo.getAddress2());
            preparedStatement.setString(6, wifiInfo.getInstlFloor());
            preparedStatement.setString(7, wifiInfo.getInstlTy());
            preparedStatement.setString(8, wifiInfo.getInstlMby());
            preparedStatement.setString(9, wifiInfo.getSvcSe());
            preparedStatement.setString(10, wifiInfo.getCmcwr());
            preparedStatement.setString(11, wifiInfo.getCnstcYear());
            preparedStatement.setString(12, wifiInfo.getInoutDoor());
            preparedStatement.setString(13, wifiInfo.getRemars3());
            preparedStatement.setString(14, wifiInfo.getLat());
            preparedStatement.setString(15, wifiInfo.getLnt());
            preparedStatement.setString(16, wifiInfo.getWorkDttm());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 하버사인
    public void calculateAndSaveDistanceForAll(double userLat, double userLnt) {
        DBManager.JdbcConnector();
        DBManager.connect();
        try (Connection conn = DBManager.getConnection();
             Statement stmt = conn.createStatement()) {

            String updateQuery = "SELECT * FROM wifi_info WHERE lat <> 0.000 AND lnt <> 0.000\n" +
                    "ORDER BY distance ASC LIMIT 20";

            ResultSet resultSet = stmt.executeQuery(updateQuery);
            while (resultSet.next()) {
                double wifiLnt = resultSet.getDouble("LNT");
                double wifiLat = resultSet.getDouble("LAT");

                double distance = calculateDistance(userLat, userLnt, wifiLat, wifiLnt);


                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setDouble(1, distance);
                //updateStmt.executeUpdate();
                //updateStmt.close();
            }
            resultSet.close();
            System.out.println("처리 완료");
        } catch (SQLException e) {
            System.out.println("실패");
            e.printStackTrace();
        }
        DBManager.disconnect(); // 이거는 혹시 몰라서 자동 종료 될까봐 명시적으로 내가 종료하겠다는 의미로 선언했음
    }


    private double calculateDistance(double userLat, double userLnt, double wifiLat, double wifiLnt) {
        final int R = 6371; // 지구 반지름 (단위: km)

        double lat1 = Math.toRadians(userLat); // 대상 위도값
        double lon1 = Math.toRadians(userLnt); // 대상 경도값

        double lat2 = Math.toRadians(wifiLat);
        double lon2 = Math.toRadians(wifiLnt);

        double latDistance = lat2 - lat1;
        double lonDistance = lon2 - lon1;

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}