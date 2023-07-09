package com.example.publicwifi.controller;

import com.example.publicwifi.service.BookmarkService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bookmark_delete", urlPatterns = "/bookmark_delete")
public class BookmarkDeleteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookmarkService bookmarkService = new BookmarkService();
        Long bookmarkId = Long.valueOf(request.getParameter("bookmarkId"));
        bookmarkService.deleteBookmark(bookmarkId);

        request.getRequestDispatcher("/WEB-INF/views/bookmark.jsp").forward(request, response);
    }

}
