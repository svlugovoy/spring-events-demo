package com.svlugovoy.eventsdemo.service;

import com.svlugovoy.eventsdemo.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> saveTwoBooks(Book book1, Book book2);
}
