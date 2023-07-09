package com.example.publicwifi.service;

import com.example.publicwifi.domain.Bookmark;
import com.example.publicwifi.repository.BookmarkRepository;

import java.util.List;

public class BookmarkService {

    public void save(String bookmarkName, String mainNm) {
        BookmarkRepository bookmarkRepository = new BookmarkRepository();
        bookmarkRepository.saveBookmark(bookmarkName, mainNm);
    }

    public List<Bookmark> getAllBookmarks() {
        BookmarkRepository bookmarkRepository = new BookmarkRepository();
        return bookmarkRepository.getAllBookmarks();
    }

    public void deleteBookmark(Long bookmarkId) {
        BookmarkRepository bookmarkRepository = new BookmarkRepository();
        bookmarkRepository.deleteBookmark(bookmarkId);
    }

}
