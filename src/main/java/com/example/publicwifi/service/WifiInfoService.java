package com.example.publicwifi.service;

import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.repository.WifiInfoRepository;
import com.example.publicwifi.util.DBManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.example.publicwifi.util.OpenApiInfo.*;

public class WifiInfoService {

    private static final int FIXATION_NUMBER = 1;

    // 공공 WIFI 총 개수 가져오기
    public Long getPublicWifiTotalCount() {
        String urlBuilder = OPEN_API_URL +
                "/" + URLEncoder.encode(KEY, StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode(TYPE, StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode(SERVICE, StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode(String.valueOf(FIXATION_NUMBER), StandardCharsets.UTF_8) +
                "/" + URLEncoder.encode(String.valueOf(FIXATION_NUMBER), StandardCharsets.UTF_8);

        try {
            URL url = new URL(urlBuilder);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader br;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            conn.disconnect();
            return Long.parseLong(sb.substring(40, 45));
        } catch (Exception e) {
            return -1L;
        }
    }

    // 공공 WIFI 데이터 가져오기 (1000개씩)
    public void getPublicWifi(long totalWifiCount) {
        try {
            // db 연동
            WifiInfoRepository wifiInfoRepository = new WifiInfoRepository();
            DBManager.JdbcConnector();
            DBManager.connect();

            BufferedReader br;
            StringBuilder sb;
            String line;

            long startIdx = 1;
            long endIdx = 1_000;

            for (int i = 0; i < totalWifiCount / 1000 + FIXATION_NUMBER; i++) {
                String urlBuilder = OPEN_API_URL +
                        "/" + URLEncoder.encode(KEY, StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(TYPE, StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(SERVICE, StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(String.valueOf(startIdx), StandardCharsets.UTF_8) +
                        "/" + URLEncoder.encode(String.valueOf(endIdx), StandardCharsets.UTF_8);

                URL url = new URL(urlBuilder);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {
                    br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }
                sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                // JSON 파싱
                JSONArray jsonArray = changeToJson(sb.toString());
                JSONObject temp;

                for (int j = 0; j < jsonArray.length(); j++) {
                    WifiInfo wifiInfo = new WifiInfo();
                    temp = (JSONObject) jsonArray.get(j);

                    wifiInfo.setMgrNo(String.valueOf(temp.get("X_SWIFI_MGR_NO")));
                    wifiInfo.setWrdofc(String.valueOf(temp.get("X_SWIFI_WRDOFC")));
                    wifiInfo.setMainNm(String.valueOf(temp.get("X_SWIFI_MAIN_NM")));
                    wifiInfo.setAddress1(String.valueOf(temp.get("X_SWIFI_ADRES1")));
                    wifiInfo.setAddress2(String.valueOf(temp.get("X_SWIFI_ADRES2")));
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
                    wifiInfoRepository.saveWifiInfo(wifiInfo);
                }
                br.close();
                conn.disconnect();
                startIdx += 1_000;
                endIdx += 1_000;
            }
            DBManager.disconnect();
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }

    // 1개 부터 -> 1000개 뽑았으면 파싱해주는 api
    public JSONArray changeToJson(String defaultApi) {
        JSONObject jsonObject = new JSONObject(defaultApi);
        JSONObject tbPublicWifiInfo = jsonObject.getJSONObject("TbPublicWifiInfo");
        return tbPublicWifiInfo.getJSONArray("row");
    }

    // 거리 계산해서 20개 전체 조회
    public List<WifiInfo> getNearestWifiInfo(String lat, String lnt) {
        WifiInfoRepository wifiInfoRepository = new WifiInfoRepository();
        List<WifiInfo> nearestWifiInfos = wifiInfoRepository.getNearestWifiInfo(lat, lnt);
        System.out.println("나는 서비스야 : " + nearestWifiInfos);

        return nearestWifiInfos;
    }

}

