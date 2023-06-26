package com.example.publicwifi.controller;

import com.example.publicwifi.service.WifiInfoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/load_wifi")
public class WifiInfoController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        WifiInfoService wifiInfoService = new WifiInfoService();
        long wifiTotalCount = wifiInfoService.getPublicWifiTotalCount(); // 와이파이 총 개수
        wifiInfoService.getPublicWifi(wifiTotalCount);
    }


}

