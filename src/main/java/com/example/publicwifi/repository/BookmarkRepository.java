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

    public void saveBookmark(String bookmarkName, String mainNm) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO bookmark(bookmark_name, mainNm, register_date) VALUES (?, ?, ?)";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookmarkName);
            preparedStatement.setString(2, mainNm);
            preparedStatement.setObject(3, LocalDateTime.now());
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

    public List<Bookmark> getAllBookmarks() {
        DBManager.JdbcConnector();
        DBManager.connect();
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
                bookmark.setMainNm(resultSet.getString(3));
                bookmark.setRegisterDate(resultSet.getString(4));
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

    public Bookmark getBookmarkById(Long bookmarkId) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Bookmark bookmark = new Bookmark();

        String query = "SELECT bookmark_name, mainNm, register_date FROM bookmark WHERE id = ?";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, bookmarkId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookmark.setId(bookmarkId);
                bookmark.setBookmarkName(resultSet.getString(1));
                bookmark.setMainNm(resultSet.getString(2));
                bookmark.setRegisterDate(resultSet.getString(3));
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
        return bookmark;
    }

    public void deleteBookmark(Long bookmarkId) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "DELETE from bookmark WHERE id =?";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, bookmarkId);
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

}