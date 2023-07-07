package com.example.publicwifi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "main", urlPatterns = "/")
public class MainController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

}


        /*
        내가 진행 하던
        request.setAttribute("latitude", lat);
        request.setAttribute("longitude", lnt);

        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
         */
