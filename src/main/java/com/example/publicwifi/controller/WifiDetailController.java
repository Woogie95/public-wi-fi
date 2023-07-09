package com.example.publicwifi.controller;

import com.example.publicwifi.domain.BookmarkGroup;
import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.repository.BookmarkGroupRepository;
import com.example.publicwifi.service.WifiInfoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "detail", urlPatterns = "/detail")
public class WifiDetailController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doService(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doService(request, response);
    }

    protected void doService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String mgrNo = request.getParameter("mgrNo");

        WifiInfoService wifiInfoService = new WifiInfoService();
        WifiInfo wifiInfoDetail = wifiInfoService.getWifiInfoDetail(mgrNo);
        request.setAttribute("wifiInfoDetail", wifiInfoDetail);

        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        List<BookmarkGroup> bookmarkGroups = bookmarkGroupRepository.getAllBookmarkGroups();

        request.setAttribute("bookmarkGroups", bookmarkGroups);
        request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
    }

}