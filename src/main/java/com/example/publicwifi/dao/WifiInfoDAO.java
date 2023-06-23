package com.example.publicwifi.dao;

import com.example.publicwifi.domain.WifiInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WifiInfoDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "tjddnr12";

    public void saveWifiInfo(WifiInfo wifiInfo) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // 쿼리 작성
            String query = "INSERT INTO wifi_info (x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm, x_swifi_adres1, x_swifi_adres2, " +
                    "x_swifi_instl_floor, x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se, x_swifi_cmcwr, x_swifi_cnstc_year, " +
                    "x_swifi_inout_door, x_swifi_remars3, lat, lnt, work_dttm) " +
                    "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepared Statement 생성
            statement = connection.prepareStatement(query);

            // 파라미터 설정 및 쿼리 실행
            for (WifiInfo wifiInfo : wifiInfoList) {
                statement.setString(1, wifiInfo.getX_swifi_mgr_no());
                statement.setString(2, wifiInfo.getX_swifi_wrdofc());
                statement.setString(3, wifiInfo.getX_swifi_main_nm());
                statement.setString(4, wifiInfo.getX_swifi_adres1());
                statement.setString(5, wifiInfo.getX_swifi_adres2());
                statement.setString(6, wifiInfo.getX_swifi_instl_floor());
                statement.setString(7, wifiInfo.getX_swifi_instl_ty());
                statement.setString(8, wifiInfo.getX_swifi_instl_mby());
                statement.setString(9, wifiInfo.getX_swifi_svc_se());
                statement.setString(10, wifiInfo.getX_swifi_cmcwr());
                statement.setString(11, wifiInfo.getX_swifi_cnstc_year());
                statement.setString(12, wifiInfo.getX_swifi_inout_door());
                statement.setString(13, wifiInfo.getX_swifi_remars3());
                statement.setString(14, wifiInfo.getLat());
                statement.setString(15, wifiInfo.getLnt());
                statement.setString(16, wifiInfo.getWork_dttm());

                // 쿼리 실행
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}