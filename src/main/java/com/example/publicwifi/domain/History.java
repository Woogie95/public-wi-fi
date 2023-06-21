package com.example.publicwifi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {

    private Long id;
    private Double latitude; // y위도
    private Double longitude; // x경도
    private LocalDateTime registerDate;

}
