package com.example.publicwifi.repository;

import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.util.DBInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WifiInfoRepository {

    public void saveWifiInfo(WifiInfo wifiInfo) {
        try {
            Class.forName(DBInfo.MY_SQL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DriverManager.getConnection(DBInfo.DB_URL, DBInfo.DB_USERNAME, DBInfo.DB_PASSWORD);
            String query = "INSERT INTO wifi_info (magNo, wrdofc, mainm,address1, address2, floor, ty," +
                    "mby, svcse, cmcwr, year, door, remars3, lat, lnt, work_dttm) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(query);
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
}








