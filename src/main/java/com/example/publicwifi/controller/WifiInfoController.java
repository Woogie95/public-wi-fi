package com.example.publicwifi.controller;

import com.example.publicwifi.service.WifiInfoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "load_wifi", urlPatterns = "/load_wifi")
public class WifiInfoController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        WifiInfoService wifiInfoService = new WifiInfoService();
        // 와이파이 총 개수
        long wifiTotalCount = wifiInfoService.getPublicWifiTotalCount(); // 카운트 하면서 디비에 저장함

        wifiInfoService.getPublicWifi(wifiTotalCount);
        request.setAttribute("totalWifiCount", wifiTotalCount);
        request.getRequestDispatcher("/WEB-INF/views/load_wifi.jsp")
                .forward(request, response);
    }

}