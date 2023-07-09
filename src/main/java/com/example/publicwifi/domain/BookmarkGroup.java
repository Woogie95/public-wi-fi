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
public class BookmarkGroup {

    private Long id;
    private String bookmarkName;
    private Long sequence;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

}
