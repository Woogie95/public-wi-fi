package com.example.publicwifi.controller;

import com.example.publicwifi.domain.History;
import com.example.publicwifi.service.HistoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "history", urlPatterns = "/history")
public class HistoryController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistoryService historyService = new HistoryService();
        List<History> histories = historyService.getAllHistories();

        request.setAttribute("history", histories);
        request.getRequestDispatcher("/WEB-INF/views/history.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HistoryService historyService = new HistoryService();
        historyService.save(request.getParameter("lat"), request.getParameter("lnt"));


    }

}