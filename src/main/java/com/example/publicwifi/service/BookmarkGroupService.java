package com.example.publicwifi.service;

import com.example.publicwifi.domain.BookmarkGroup;
import com.example.publicwifi.repository.BookmarkGroupRepository;

import java.util.List;

public class BookmarkGroupService {

    public void save(String bookmarkGroupName, Long bookmarkGroupSequence) {
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        bookmarkGroupRepository.save(bookmarkGroupName, bookmarkGroupSequence);
    }

    public BookmarkGroup getBookmarkGroupById(Long bookmarkGroupId) {
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        return bookmarkGroupRepository.getBookmarkGroupById(bookmarkGroupId);
    }

    public void updateBookmark(Long bookmarkGroupId,String bookmarkGroupName, Long sequence) {
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        bookmarkGroupRepository.updateBookmark(bookmarkGroupId, bookmarkGroupName, sequence);
    }

    public List<BookmarkGroup> getAllBookmarkGroups() {
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        return bookmarkGroupRepository.getAllBookmarkGroups();
    }

    public void deleteBookmark(Long id) {
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        bookmarkGroupRepository.deleteBookmarkGroup(id);
    }
}
