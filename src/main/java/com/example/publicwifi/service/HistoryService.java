package com.example.publicwifi.service;

import com.example.publicwifi.domain.History;
import com.example.publicwifi.repository.HistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

public class HistoryService {

    public void save(String lat, String lnt) {
        History history = new History();
        history.setLat(Double.valueOf(lat));
        history.setLnt(Double.valueOf(lnt));
        history.setRegisterDate(LocalDateTime.now());
        HistoryRepository historyRepository = new HistoryRepository();
        historyRepository.saveHistory(history);
    }

    public List<History> getAllHistories() {
        HistoryRepository historyRepository = new HistoryRepository();
        return historyRepository.getAllHistories();
    }
}
