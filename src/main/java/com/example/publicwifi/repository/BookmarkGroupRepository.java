package com.example.publicwifi.repository;

import com.example.publicwifi.domain.Bookmark;
import com.example.publicwifi.domain.BookmarkGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookmarkGroupRepository {

    // 전체 조회
    public List<BookmarkGroup> getAllBookmarkGroup() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookmarkGroup> bookmarkGroups = new ArrayList<>();
// 북마크 여기 하는중 --------------------------------------------------->>>>>>>>>>>>>>>>>>


        try {
            conn = dbConn.getConnection();

            String query = "SELECT * FROM bookmark_group";
            pstmt = conn.prepareStatement(query);
            rs= pstmt.executeQuery();
            while(rs.next()) {
                BookmarkGroupDTO bk = new BookmarkGroupDTO();
                bk.setBmk_mno(rs.getInt(1));
                bk.setBmk_name(rs.getString(2));
                bk.setBmk_sequence(rs.getInt(3));
                bk.setReg_date(rs.getString(4));
                bk.setMod_date(rs.getString(5));
                bmklist.add(bk);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.close(conn, pstmt, rs);
        }

        return bmklist;
    }
}
