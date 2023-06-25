package com.example.publicwifi.api;

import com.example.publicwifi.dao.WifiInfoDAO;
import com.example.publicwifi.domain.WifiInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiService {

    private static final String OPEN_API_URL = "https://openapi.seoul.go.kr:8088/";
    private static final String KEY = "6a7348784d63686f35345a7370506d";
    private static final String TYPE = "json";
    private static final String SERVICE = "TbPublicWifiInfo";

    // 데이터 총 개수
    public int getPublicWifiSize() throws IOException {
        String urlBuilder = OPEN_API_URL + "/" + URLEncoder.encode(KEY, StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode(TYPE, StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode(SERVICE, StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode("1", StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode("1", StandardCharsets.UTF_8);

        URL url = new URL(urlBuilder);
        System.out.println(url);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json");
        BufferedReader bufferedReader;
        if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        connection.disconnect();
        String totalWifi = stringBuilder.substring(40, 45);
        return Integer.parseInt(totalWifi);
    }

    // 데이터 db 저장
    public void insertWifi() {
        try{
            long total = getPublicWifiSize();
            BufferedReader bufferedReader;
            StringBuilder stringBuilder;
            String line;

            int idx = 1;
            for (int i = 0; i < total / 1000 + 1; i++) {
                String urlBuilder = OPEN_API_URL + "/" + URLEncoder.encode(KEY, StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(TYPE, StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(SERVICE, StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(String.valueOf(idx), StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(String.valueOf(idx + 999), StandardCharsets.UTF_8);

                URL url = new URL(urlBuilder);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");

                if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
                    bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }
                stringBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                JSONObject result = (JSONObject) new JSONParser().parse(stringBuilder.toString());
                JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
                JSONArray array = (JSONArray) data.get("row");
                JSONObject temp;
                for (int j = 0; j < array.size(); j++) {
                    WifiInfo wifiInfo = new WifiInfo();
                    temp = (JSONObject) array.get(j);
                    wifiInfo.setMgrNo(String.valueOf(temp.get("X_SWIFI_MGR_NO")));
                    wifiInfo.setWrdofc(String.valueOf(temp.get("X_SWIFI_WRDOFC")));
                    wifiInfo.setMainNm(String.valueOf(temp.get("X_SWIFI_MAIN_NM")));
                    wifiInfo.setAddress1(String.valueOf(temp.get("X_SWIFI_ADRESS1")));
                    wifiInfo.setAddress2(String.valueOf(temp.get("X_SWIFI_ADRESS2")));
                    wifiInfo.setInstlFloor(String.valueOf(temp.get("X_SWIFI_INSTL_FLOOR")));
                    wifiInfo.setInstlTy(String.valueOf(temp.get("X_SWIFI_INSTL_TY")));
                    wifiInfo.setInstlMby(String.valueOf(temp.get("X_SWIFI_INSTL_MBY")));
                    wifiInfo.setSvcSe(String.valueOf(temp.get("X_SWIFI_SVC_SE")));
                    wifiInfo.setCmcwr(String.valueOf(temp.get("X_SWIFI_CMCWR")));
                    wifiInfo.setCnstcYear(String.valueOf(temp.get("X_SWIFI_CNSTC_YEAR")));
                    wifiInfo.setInoutDoor(String.valueOf(temp.get("X_SWIFI_INOUT_DOOR")));
                    wifiInfo.setRemars3(String.valueOf(temp.get("X_SWIFI_REMARS3")));
                    wifiInfo.setLat(String.valueOf(temp.get("LAT")));
                    wifiInfo.setLnt(String.valueOf(temp.get("LNT")));
                    wifiInfo.setWorkDttm(String.valueOf(temp.get("WORK_DTTM")));

                    System.out.println(wifiInfo.getMgrNo());
                    WifiInfoDAO wifiInfoDAO = new WifiInfoDAO();
                    wifiInfoDAO.saveWifiInfo(wifiInfo);
                }
                bufferedReader.close();
                connection.disconnect();
                idx += 1000;
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }

}
