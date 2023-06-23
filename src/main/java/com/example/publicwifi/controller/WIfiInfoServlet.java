//package com.example.publicwifi.controller;
//
//import com.example.publicwifi.dao.WifiInfoDAO;
//import com.example.publicwifi.domain.WifiInfo;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/home")
//public class WIfiInfoServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("asdasdsad");
//        // JSON 파일 읽기
//        String jsonFilePath = "/Users/sungwook/Downloads/wifi_info.json";
//        String jsonData = readJsonFile(jsonFilePath);
//
//        // JSON 데이터 파싱
//        List<WifiInfo> wifiInfoList = parseJsonData(jsonData);
//
//        // DAO 클래스를 사용하여 데이터베이스에 저장
//        WifiInfoDAO wifiInfoDAO = new WifiInfoDAO();
//        wifiInfoDAO.saveWifiInfo(wifiInfoList);
//
//        // 응답 생성
//        response.setContentType("text/plain");
//        response.getWriter().write("데이터가 데이터베이스에 성공적으로 저장되었습니다.");
//    }
//
//    // JSON 파일 읽기 메서드
//    private String readJsonFile(String jsonFilePath) throws IOException {
//        // JSON 파일을 읽어서 문자열로 반환하는 로직 작성
//        String jsonData = Files.readString(Paths.get(jsonFilePath));
//        return jsonData;
//    }
//
//    // JSON 데이터 파싱 메서드
//    private List<WifiInfo> parseJsonData(String jsonData) {
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
//        JsonArray rowArray = jsonObject.getAsJsonObject("wifiInfo").getAsJsonArray("row");
//
//        List<WifiInfo> wifiInfoList = new ArrayList<>();
//        for (JsonElement rowElement : rowArray) {
//            JsonObject rowObject = rowElement.getAsJsonObject();
//            WifiInfo wifiInfo = new WifiInfo();
//            wifiInfo.setX_swifi_mgr_no(rowObject.get("X_SWIFI_MGR_NO").getAsString());
//            wifiInfo.setX_swifi_wrdofc(rowObject.get("X_SWIFI_WRDOFC").getAsString());
//            wifiInfo.setX_swifi_main_nm(rowObject.get("X_SWIFI_MAIN_NM").getAsString());
//            wifiInfo.setX_swifi_adres1(rowObject.get("X_SWIFI_ADRESS1").getAsString());
//            wifiInfo.setX_swifi_adres2(rowObject.get("X_SWIFI_ADRESS2").getAsString());
//            wifiInfo.setX_swifi_instl_floor(rowObject.get("X_SWIFI_INSTL_FLOOR").getAsString());
//            wifiInfo.setX_swifi_instl_ty(rowObject.get("X_SWIFI_INSTL_TY").getAsString());
//            wifiInfo.setX_swifi_instl_mby(rowObject.get("X_SWIFI_INSTL_MBY").getAsString());
//            wifiInfo.setX_swifi_svc_se(rowObject.get("X_SWIFI_SVC_SE").getAsString());
//            wifiInfo.setX_swifi_cmcwr(rowObject.get("X_SWIFI_CMCWR").getAsString());
//            wifiInfo.setX_swifi_cnstc_year(rowObject.get("X_SWIFI_CNSTC_YEAR").getAsString());
//            wifiInfo.setX_swifi_inout_door(rowObject.get("X_SWIFI_INOUT_DOOR").getAsString());
//            wifiInfo.setX_swifi_remars3(rowObject.get("X_SWIFI_REMARS3").getAsString());
//            wifiInfo.setLat(rowObject.get("LAT").getAsString());
//            wifiInfo.setLnt(rowObject.get("LNT").getAsString());
//            wifiInfo.setWork_dttm(rowObject.get("WORK_DTTM").getAsString());
//            wifiInfoList.add(wifiInfo);
//        }
//        return wifiInfoList;
//    }
//}