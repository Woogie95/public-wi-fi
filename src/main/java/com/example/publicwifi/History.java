package com.example.publicwifi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class History {

    private Long id;
    private Double longitude; // x경도
    private Double latitude; // y위도
    private LocalDateTime registerDate;

}
