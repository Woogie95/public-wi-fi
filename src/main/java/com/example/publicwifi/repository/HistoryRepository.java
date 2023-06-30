package com.example.publicwifi.repository;

import com.example.publicwifi.domain.History;
import com.example.publicwifi.util.DBManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.publicwifi.util.DBManager.getConnection;

public class HistoryRepository {

    // 등록
    public void saveHistory(History history) {
        DBManager.JdbcConnector();
        String query = "INSERT INTO history (lat, lnt, register_date) VALUES (?, ?, ?)";

        Connection conn = getConnection();
        DBManager.connect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBManager.getConnection().prepareStatement(query);
            preparedStatement.setDouble(1, history.getLat());
            preparedStatement.setDouble(2, history.getLnt());
            preparedStatement.setObject(3, history.getRegisterDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBManager.disconnect();
    }

    // 내림차순으로 전체 조회
    public List<History> getAllHistories() {
        List<History> historyList = new ArrayList<>();
        String query = "SELECT * FROM history ORDER BY id DESC";
        DBManager.JdbcConnector();
        Connection conn = getConnection();
        DBManager.connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = DBManager.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Double lat = resultSet.getDouble("lat");
                Double lnt = resultSet.getDouble("lnt");
                Timestamp tempDate = resultSet.getTimestamp("register_date");
                LocalDateTime registerDate = tempDate.toLocalDateTime();
                History history = new History(id, lat, lnt, registerDate);
                historyList.add(history);
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
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return historyList;
    }

    // 삭제
    public void deleteHistory(Long id) {
        DBManager.JdbcConnector();
        String query = "DELETE FROM history WHERE id = ?";

        Connection conn = getConnection();
        DBManager.connect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBManager.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("해당 정보가 삭제 되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBManager.disconnect();
    }

}