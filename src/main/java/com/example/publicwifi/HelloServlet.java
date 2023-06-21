//package com.example.publicwifi;
//
//import java.io.*;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            // OpenAPI URL 및 API 키 설정
//            String apiUrl = "https://openapi.seoul.go.kr:8088/6a7348784d63686f35345a7370506d/json/TbPublicWifiInfo/1/1000/";
//
//            // OpenAPI에서 데이터 가져오기
//            URL url = new URL(apiUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            // 응답 코드 확인
//            int responseCode = conn.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                // 데이터 읽기
//                InputStream inputStream = conn.getInputStream();
//                byte[] buffer = new byte[1024];
//                StringBuilder stringBuilder = new StringBuilder();
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    stringBuilder.append(new String(buffer, 0, bytesRead));
//                }
//
//                // JSON 데이터 파싱
//                JSONObject json = new JSONObject(stringBuilder.toString());
//                JSONObject wifiInfo = json.getJSONObject("TbPublicWifiInfo");
//                JSONArray wifiList = wifiInfo.getJSONArray("row");
//
//                // DB에 데이터 삽입
//                for (int i = 0; i < wifiList.length(); i++) {
//                    JSONObject wifi = wifiList.getJSONObject(i);
//                    String wifiName = wifi.getString("WIFI_NAME");
//                    String wifiAddress = wifi.getString("WIFI_ADDR");
//
//                    // JDBC를 사용하여 DB에 데이터 삽입
//                    // 삽입 작업 수행
//                }
//
//                response.getWriter().println("데이터가 DB에 삽입되었습니다.");
//            } else {
//                response.getWriter().println("데이터 가져오기 실패: " + responseCode);
//            }
//        }
//
//
//}