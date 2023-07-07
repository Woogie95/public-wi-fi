package com.example.publicwifi.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "delete_bookmark", urlPatterns = "/delete_bookmark")
public class BookmarkDeleteController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}

