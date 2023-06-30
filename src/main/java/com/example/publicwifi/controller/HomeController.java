package com.example.publicwifi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "home", urlPatterns = "/")
public class HomeController extends HttpServlet {

    // 메인 호출
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
    }

    // 내 위치 가져오기 버튼 클릭 시 위도, 경도를 포함하여 화면에 보여짐
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String lat = request.getParameter("lat");
        String lnt = request.getParameter("lnt");
        request.setAttribute("latitude", lat);
        request.setAttribute("longitude", lnt);

        // 여기서 경도, 위도 로

        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
    }

}