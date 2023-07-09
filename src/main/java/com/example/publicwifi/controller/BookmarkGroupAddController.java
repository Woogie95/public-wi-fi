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

@WebServlet(name = "bookmark_group_add", urlPatterns = "/bookmark_group_add")
public class BookmarkGroupAddController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookmarkGroupName = request.getParameter("bookmarkGroupName");
        Long bookmarkGroupSequence = Long.valueOf(request.getParameter("bookmarkGroupSequence"));

        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
        bookmarkGroupService.save(bookmarkGroupName, bookmarkGroupSequence);

        List<BookmarkGroup> bookmarkGroups = bookmarkGroupService.getAllBookmarkGroups();

        request.setAttribute("bookmarkGroups", bookmarkGroups);
        request.getRequestDispatcher("/WEB-INF/views/bookmark_group.jsp").forward(request, response);
    }

}
