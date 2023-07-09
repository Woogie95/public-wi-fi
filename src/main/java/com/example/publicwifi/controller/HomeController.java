package com.example.publicwifi.controller;


import com.example.publicwifi.domain.WifiInfo;
import com.example.publicwifi.service.HistoryService;
import com.example.publicwifi.service.WifiInfoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lat = request.getParameter("lat");
        String lnt = request.getParameter("lnt");

        HistoryService historyService = new HistoryService();
        historyService.save(lat, lnt);

        WifiInfoService wifiInfoService = new WifiInfoService();
        List<WifiInfo> wifiInfoList = wifiInfoService.getNearWifiInfo(lat, lnt);

        request.setAttribute("wifiInfoList", wifiInfoList);
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

}