package com.example.publicwifi.domain;

import java.time.LocalDateTime;

public class History {

    private Long id;
    private Double lat; // 위도
    private Double lnt; // 경도
    private LocalDateTime registerDate;

    public History() {
    }

    public History(Long id, Double lat, Double lnt, LocalDateTime registerDate) {
        this.id = id;
        this.lat = lat;
        this.lnt = lnt;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLnt() {
        return lnt;
    }

    public void setLnt(Double lnt) {
        this.lnt = lnt;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
}
