package com.example.publicwifi.controller;

import com.example.publicwifi.service.HistoryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "deleteHistory", urlPatterns = "/delete_history")
public class HistoryDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HistoryService historyService = new HistoryService();
        historyService.deleteHistory(request.getParameter("historyId"));
    }
}
