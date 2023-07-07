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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        double lat = Double.parseDouble(request.getParameter("lat"));
//        double lnt = Double.parseDouble(request.getParameter("lnt"));
//        System.out.println("와이파이컨트롤러 : " + lat + " " + lnt);
//
//        WifiInfoRepository wifiInfoRepository = new WifiInfoRepository();
//        List<WifiInfo> wifiInfoList = wifiInfoRepository.getAllWifiInfo(lat, lnt);
//
//        for (WifiInfo wifiInfo : wifiInfoList) {
//            System.out.println("거리 : " + wifiInfo.getDistance());
//            System.out.println("이름 : " + wifiInfo.getMainNm());
//        }
//
//        request.setAttribute("wifiInfoList", wifiInfoList);
//        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
//                .forward(request, response);
    }

}