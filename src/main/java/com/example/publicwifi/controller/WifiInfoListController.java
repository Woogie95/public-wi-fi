package com.example.publicwifi.controller;

import com.example.publicwifi.repository.WifiInfoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "wifiInfoList", urlPatterns = "/wifiInfo_list")
public class WifiInfoListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 목록 구현하기 따로 하자
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lnt = Double.parseDouble(request.getParameter("lnt"));


        WifiInfoRepository wifiInfoRepository = new WifiInfoRepository();
        wifiInfoRepository.calculateAndSaveDistanceForAll(lat, lnt);

// 왜 2번?

//        request.setAttribute("wifiInfoList", nearWifiList);
        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
    }
}
