package com.example.publicwifi.dao;

import com.example.publicwifi.domain.WifiInfo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WifiDAO {
    public static final String url = "jdbc:mysql://localhost:3306/project";

    public void saveWifiInfo(String filePath) {
        // MySQL 데이터베이스 연결 정보 설정
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your-username";
        String password = "your-password";

        // JSON 파일 파싱 및 데이터베이스 저장 처리
        try {
            // JSON 파일 읽기
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            // MySQL 데이터베이스 연결
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            // JSON 데이터 처리
            for (Object obj : jsonArray) {
                JSONObject jsonObj = (JSONObject) obj;

                // 필요한 데이터 추출
                String name = (String) jsonObj.get("name");
                String email = (String) jsonObj.get("email");

                // MySQL에 데이터 삽입
                String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, email);
                statement.executeUpdate();

                // 사용한 자원 해제
                statement.close();
            }

            // 연결과 리더 해제
            conn.close();
            reader.close();

            System.out.println("JSON 데이터를 MySQL에 저장하였습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

    public String getWifiInfo() {
        String jsonFilePath = "/Users/sungwook/Downloads/wifi_info.json";
        // 데이터베이스 연결 정보
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "tjddnr12";
        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSON 파일 읽기
            File jsonFile = new File(jsonFilePath);

            // JSON 파일을 자바 객체로 변환
            WifiInfo wifiInfo = objectMapper.readValue(jsonFile, WifiInfo.class);

            // 데이터베이스에 연결
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);

            // 데이터 삽입
            try (Connection connection = dataSource.getConnection()) {
                // 데이터 삽입 SQL 실행
                String sql = "INSERT INTO wifi_info (key, value) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, wifiInfo.getKey());
                statement.setString(2, wifiInfo.getValue());
                statement.executeUpdate();

                System.out.println("데이터가 성공적으로 데이터베이스에 저장되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "성공";
    }
}
