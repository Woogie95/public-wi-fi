package com.example.publicwifi.repository;

import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.publicwifi.util.DBManager.JdbcConnector;
import static com.example.publicwifi.util.DBManager.getConnection;

public class WifiInfoRepository {

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

    // 위도, 경도를 가지고 20개 조회하기
    public List<WifiInfo> getNearestWifiInfo(String lat, String lnt) {
        List<WifiInfo> nearestWifiList = new ArrayList<>();
        JdbcConnector();
        DBManager.connect();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT *, sqrt(((CAST(lat AS DOUBLE) - ?) * (CAST(lat AS DOUBLE) - ?))" +
                             " + ((CAST(lnt AS DOUBLE) - ?) * (CAST(lnt AS DOUBLE) - ?))) " +
                             "as distance FROM wifi_info ORDER BY distance ASC LIMIT 20")) {

            preparedStatement.setDouble(1, Double.parseDouble(lat));
            preparedStatement.setDouble(2, Double.parseDouble(lat));
            preparedStatement.setDouble(3, Double.parseDouble(lnt));
            preparedStatement.setDouble(4, Double.parseDouble(lnt));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.setDistance((double) resultSet.getInt("distance"));
                wifiInfo.setMgrNo(resultSet.getString("mgrNo"));
                wifiInfo.setWrdofc(resultSet.getString("wrdofc"));
                wifiInfo.setMainNm(resultSet.getString("mainNm"));
                wifiInfo.setAddress1(resultSet.getString("address1"));
                wifiInfo.setAddress2(resultSet.getString("address2"));
                wifiInfo.setInstlFloor(resultSet.getString("instlFloor"));
                wifiInfo.setInstlTy(resultSet.getString("instlTy"));
                wifiInfo.setInstlMby(resultSet.getString("instlMby"));
                wifiInfo.setSvcSe(resultSet.getString("svcSe"));
                wifiInfo.setCmcwr(resultSet.getString("cmcwr"));
                wifiInfo.setCnstcYear(resultSet.getString("cnstcYear"));
                wifiInfo.setInoutDoor(resultSet.getString("inoutDoor"));
                wifiInfo.setRemars3(resultSet.getString("remars3"));
                wifiInfo.setLat(resultSet.getString("lat"));
                wifiInfo.setLnt(resultSet.getString("lnt"));
                wifiInfo.setWorkDttm(resultSet.getString("workDttm"));

                System.out.println("안녕");
                System.out.println(wifiInfo);

                nearestWifiList.add(wifiInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nearestWifiList;

    }

}