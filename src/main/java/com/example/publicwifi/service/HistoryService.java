//package com.example.publicwifi.service;
//
//import com.example.publicwifi.domain.History;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//
//public class HistoryService {
//    public void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        Long id = Long.valueOf(request.getParameter("id"));
//        Double lat = Double.valueOf(request.getParameter("lat"));
//        Double lnt = Double.valueOf(request.getParameter("lnt"));
//        LocalDateTime registerDate = LocalDateTime.parse(request.getParameter("registerDate"));
//        History history = new History(id, lat, lnt, registerDate);
//        userDAO.insertUser(newUser);
//        response.sendRedirect("list");
//    }
//}
