package com.example.publicwifi.controller;

import com.example.publicwifi.api.ApiService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class MainServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        ApiService apiService = new ApiService();
        apiService.insertWifi();

        request.setAttribute("apiService", apiService);
        request.getRequestDispatcher("/WEB-INF/view/home.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=utf-8");
        ApiService apiService = new ApiService();
        apiService.insertWifi();
    }

}
