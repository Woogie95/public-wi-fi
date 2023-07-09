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

@WebServlet(name = "bookmark_group", urlPatterns = "/bookmark_group")
public class BookmarkGroupController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();

        List<BookmarkGroup> bookmarkGroups = bookmarkGroupService.getAllBookmarkGroups();
        request.setAttribute("bookmarkGroups", bookmarkGroups);

        request.getRequestDispatcher("/WEB-INF/views/bookmark_group.jsp").forward(request, response);
    }

}
