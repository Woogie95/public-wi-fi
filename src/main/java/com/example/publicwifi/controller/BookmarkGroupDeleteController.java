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

@WebServlet(name = "bookmark_group_delete", urlPatterns = "/bookmark_group_delete")
public class BookmarkGroupDeleteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
        String bookmarkGroupId = request.getParameter("bookmarkGroupId");

        BookmarkGroup bookmarkGroup = bookmarkGroupService.getBookmarkGroupById(Long.valueOf(bookmarkGroupId));

        request.setAttribute("bookmarkGroup", bookmarkGroup);
        request.getRequestDispatcher("/WEB-INF/views/bookmark_group_delete.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
        Long bookmarkId = Long.valueOf(request.getParameter("bookmarkGroupId"));

        bookmarkGroupService.deleteBookmark(bookmarkId);
        List<BookmarkGroup> bookmarkGroups = bookmarkGroupService.getAllBookmarkGroups();

        request.setAttribute("bookmarkGroups", bookmarkGroups);
        request.getRequestDispatcher("/WEB-INF/views/bookmark_group.jsp").forward(request, response);

    }

}

