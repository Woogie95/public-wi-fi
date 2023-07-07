package com.example.publicwifi.repository;

import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.service.DistanceCalculate;
import com.example.publicwifi.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;

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

    // 전체 조회
    public List<WifiInfo> getAllWifiInfo(double userLat, double userLnt) {
        String query = "SELECT * FROM wifi_info";
        DBManager.JdbcConnector();
        Connection connection = getConnection();
        DBManager.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<WifiInfo> wifiInfoList = null;
        PriorityQueue<WifiInfo> distanceQueue = null;
        try {
            preparedStatement = DBManager.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            distanceQueue = new PriorityQueue<>(Comparator.comparingDouble(WifiInfo::getDistance));

            while (resultSet.next()) {
                double lat = resultSet.getDouble("LAT");
                double lnt = resultSet.getDouble("LNT");
                DecimalFormat decimalFormat = new DecimalFormat("#.####"); // 소숫점 네 자리까지 포맷
                double distance = Double.parseDouble(decimalFormat.format(DistanceCalculate.calculateDistance(userLat, userLnt, lat, lnt)));

                if (distance < 20) {
                    WifiInfo wifiInfo = new WifiInfo(
                            distance,
                            resultSet.getString("x_wifi_mgr_no"),
                            resultSet.getString("x_wifi_wrdo_fc"),
                            resultSet.getString("x_wifi_main_nm"),
                            resultSet.getString("x_wifi_adres1"),
                            resultSet.getString("x_wifi_adres2"),
                            resultSet.getString("x_wifi_instl_floor"),
                            resultSet.getString("x_wifi_instl_ty"),
                            resultSet.getString("x_wifi_instl_mby"),
                            resultSet.getString("x_wifi_svc_se"),
                            resultSet.getString("x_wifi_cmcwr"),
                            resultSet.getString("x_wifi_cnstc_year"),
                            resultSet.getString("x_wifi_inout_door"),
                            resultSet.getString("x_wifi_remars3"),
                            resultSet.getString("lat"),
                            resultSet.getString("lnt"),
                            resultSet.getString("work_dttm"));
                    distanceQueue.offer(wifiInfo);
                    if (distanceQueue.size() > 20) {
                        distanceQueue.poll();
                    }
                }
            }
            wifiInfoList = new ArrayList<>(distanceQueue);
            wifiInfoList.sort(Comparator.comparingDouble(WifiInfo::getDistance));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBManager.disconnect();
        }
        return wifiInfoList;
    }

    // 상세 조회
    public WifiInfo getWifiInfoDetail(String mgrNo) {
        String query = "SELECT * FROM wifi_info WHERE x_wifi_mgr_no = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        WifiInfo wifiInfo = null;

        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, mgrNo);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                wifiInfo = new WifiInfo(
                        resultSet.getDouble("distance"),
                        resultSet.getString("x_wifi_mgr_no"),
                        resultSet.getString("x_wifi_wrdo_fc"),
                        resultSet.getString("x_wifi_main_nm"),
                        resultSet.getString("x_wifi_adres1"),
                        resultSet.getString("x_wifi_adres2"),
                        resultSet.getString("x_wifi_instl_floor"),
                        resultSet.getString("x_wifi_instl_ty"),
                        resultSet.getString("x_wifi_instl_mby"),
                        resultSet.getString("x_wifi_svc_se"),
                        resultSet.getString("x_wifi_cmcwr"),
                        resultSet.getString("x_wifi_cnstc_year"),
                        resultSet.getString("x_wifi_inout_door"),
                        resultSet.getString("x_wifi_remars3"),
                        resultSet.getString("lat"),
                        resultSet.getString("lnt"),
                        resultSet.getString("work_dttm")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBManager.disconnect();
        }
        return wifiInfo;
    }

}