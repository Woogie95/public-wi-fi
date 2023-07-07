package com.example.publicwifi.repository;

import com.example.publicwifi.domain.Bookmark;
import com.example.publicwifi.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkRepository {

    // 등록
    public void saveBookmark(String bookmarkName, String mainNm) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO bookmark(bookmark_name, main_nm, register_date) VALUES (?, ?, ?)";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookmarkName);
            preparedStatement.setString(2, mainNm);
            preparedStatement.setString(3, String.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }


    // 전체 조회
    public List<Bookmark> getAllBookmarks() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bookmark> bookmarks = new ArrayList<>();

        String query = "SELECT * FROM bookmark";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bookmark bookmark = new Bookmark();
                bookmark.setId(resultSet.getLong(1));
                bookmark.setBookmarkName(resultSet.getString(2));
                bookmark.setWifiName(resultSet.getString(3));
                bookmark.setRegisterDate(LocalDateTime.parse(resultSet.getString(4)));
                bookmarks.add(bookmark);
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
        return bookmarks;
    }

}
