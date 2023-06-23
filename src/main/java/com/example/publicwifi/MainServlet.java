package com.example.publicwifi;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/")
public class MainServlet extends HttpServlet {
    public void init() {
        System.out.println("Init!!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doGet!!!");
        response.setContentType("text/html");
    }

    public void destroy() {
        System.out.println("destroy!!!");
    }

}
