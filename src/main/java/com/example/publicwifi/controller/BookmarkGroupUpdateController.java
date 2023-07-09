package com.example.publicwifi.controller;

import com.example.publicwifi.domain.BookmarkGroup;
import com.example.publicwifi.service.BookmarkGroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookmark_group_update", urlPatterns = "/bookmark_group_update")
public class BookmarkGroupUpdateController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
        Long bookmarkGroupId = Long.valueOf(request.getParameter("bookmarkGroupId"));

        BookmarkGroup bookmarkGroup = bookmarkGroupService.getBookmarkGroupById(bookmarkGroupId);
        request.setAttribute("bookmarkGroup", bookmarkGroup);

        request.getRequestDispatcher("/WEB-INF/views/bookmark_group_update.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();

        Long bookmarkGroupId = Long.valueOf(request.getParameter("bookmarkGroupId"));

        String bookmarkGroupName = request.getParameter("bookmarkGroupName");
        Long bookmarkGroupSequence = Long.valueOf(request.getParameter("bookmarkGroupSequence"));

        bookmarkGroupService.updateBookmark(bookmarkGroupId, bookmarkGroupName, bookmarkGroupSequence);
        List<BookmarkGroup> bookmarkGroups = bookmarkGroupService.getAllBookmarkGroups();

        // 데이터를 request 객체에 저장
        request.setAttribute("bookmarkGroups", bookmarkGroups);
        request.getRequestDispatcher("/WEB-INF/views/bookmark_group.jsp").forward(request, response);
    }

}
