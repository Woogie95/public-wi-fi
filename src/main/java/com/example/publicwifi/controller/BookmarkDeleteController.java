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

@WebServlet(name = "bookmark_delete", urlPatterns = "/bookmark_delete")
public class BookmarkDeleteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookmarkService bookmarkService = new BookmarkService();
        Long bookmarkId = Long.valueOf(request.getParameter("bookmarkId"));

        Bookmark bookmark = bookmarkService.getBookmarkById(bookmarkId);

        request.setAttribute("bookmark", bookmark);
        request.getRequestDispatcher("/WEB-INF/views/bookmark_delete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookmarkService bookmarkService = new BookmarkService();
        Long bookmarkId = Long.valueOf(request.getParameter("bookmarkId"));

        bookmarkService.deleteBookmark(bookmarkId);
        List<Bookmark> bookmarkGroups = bookmarkService.getAllBookmarks();
        request.setAttribute("bookmark", bookmarkGroups);
        request.getRequestDispatcher("/WEB-INF/views/bookmark.jsp").forward(request, response);

    }


}
