package com.example.publicwifi.controller;

import com.example.publicwifi.domain.Bookmark;
import com.example.publicwifi.service.BookmarkService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookmark", urlPatterns = "/bookmark")
public class BookmarkController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookmarkService bookmarkService = new BookmarkService();

        List<Bookmark> bookmark = bookmarkService.getAllBookmarks();
        request.setAttribute("bookmark", bookmark);

        request.getRequestDispatcher("/WEB-INF/views/bookmark.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookmarkName = request.getParameter("bookmarkName");
        String mainNm = request.getParameter("mainNm");
        BookmarkService bookmarkService = new BookmarkService();
        bookmarkService.save(bookmarkName, mainNm);

        List<Bookmark> bookmarks = bookmarkService.getAllBookmarks();

        request.setAttribute("bookmarks", bookmarks);
        request.getRequestDispatcher("/WEB-INF/views/bookmark.jsp").forward(request, response);
    }

}
