package com.example.publicwifi.service;

import com.example.publicwifi.domain.WifiInfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DistanceCalculate {

    private DecimalFormat decimalFormat;

    public DistanceCalculate() {
        decimalFormat = new DecimalFormat("#.####"); // 소숫점 네 자리까지 포맷
    }

    public void calculateDistance(String latitude, String longitude, List<WifiInfo> wifiInfoList) {
        double lat = Double.parseDouble(latitude);
        double lnt = Double.parseDouble(longitude);

        List<Point> saveLoc = new ArrayList<>();

        for (WifiInfo wifiInfo : wifiInfoList) {
            double tempLat = Double.parseDouble(wifiInfo.getLat());
            double tempLnt = Double.parseDouble(wifiInfo.getLnt());
            saveLoc.add(new Point(tempLat, tempLnt));
        }

        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < wifiInfoList.size(); i++) {
            double distance = distance(lat, lnt, saveLoc.get(i).lat, saveLoc.get(i).lnt);
            if (distance < 2) { // 4킬로미터 이내
                distance = Double.parseDouble(decimalFormat.format(distance)); // 반올림하여 소숫점 네 자리까지 저장
                distances.add(distance);
                wifiInfoList.get(i).setDistance(distance);
            }
        }
        System.out.println(distances);
    }


    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1609.344;

        return dist / 1000; // 단위 kilometer
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}

class Point {
    double lat;
    double lnt;

    Point(double lat, double lnt) {
        this.lat = lat;
        this.lnt = lnt;
    }
}