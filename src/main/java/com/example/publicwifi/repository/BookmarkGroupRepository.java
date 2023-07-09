package com.example.publicwifi.repository;

import com.example.publicwifi.domain.BookmarkGroup;
import com.example.publicwifi.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkGroupRepository {

    // 등록
    public void save(String bookmarkName, Long sequence) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO bookmark_group (bookmark_name, sequence, register_date) VALUES (?, ?, ?)";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookmarkName);
            preparedStatement.setLong(2, sequence);
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

    // 전체 조회
    public List<BookmarkGroup> getAllBookmarkGroups() {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookmarkGroup> bookmarkGroups = new ArrayList<>();

        String query = "SELECT * FROM bookmark_group";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookmarkGroup bookmarkGroup = new BookmarkGroup();
                bookmarkGroup.setId(resultSet.getLong(1));
                bookmarkGroup.setBookmarkName(resultSet.getString(2));
                bookmarkGroup.setSequence(resultSet.getLong(3));
                bookmarkGroup.setRegisterDate(resultSet.getString(4));
                bookmarkGroup.setUpdateDate(resultSet.getString(5));
                bookmarkGroups.add(bookmarkGroup);
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
        return bookmarkGroups;
    }

    public BookmarkGroup getBookmarkGroupById(Long bookmarkGroupId) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BookmarkGroup bookmarkGroup = new BookmarkGroup();

        String query = "SELECT bookmark_name, sequence FROM bookmark_group WHERE id = ?";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, bookmarkGroupId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookmarkGroup.setId(bookmarkGroupId);
                bookmarkGroup.setBookmarkName(resultSet.getString(1));
                bookmarkGroup.setSequence(resultSet.getLong(2));
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
        return bookmarkGroup;
    }

    public void updateBookmark(Long bookmarkGroupId, String bookmarkGroupName, Long sequence) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String query = "UPDATE bookmark_group set bookmark_name = ?, sequence = ?, update_date = ? where id = ?";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookmarkGroupName);
            preparedStatement.setLong(2, sequence);
            preparedStatement.setString(3, LocalDateTime.now().toString());
            preparedStatement.setLong(4, bookmarkGroupId);
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


    public void deleteBookmarkGroup(Long id) {
        DBManager.JdbcConnector();
        DBManager.connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM bookmark_group where id = ?";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
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
