package com.example.publicwifi.controller;

import com.example.publicwifi.domain.WifiInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class WIfiInfoServletTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Reader reader = new FileReader("/Users/sungwook/Downloads/wifi_info.json");
        Gson gson = new Gson();
        WifiInfo lecture = gson.fromJson(reader, WifiInfo.class);
        System.out.println(lecture);
    }
}