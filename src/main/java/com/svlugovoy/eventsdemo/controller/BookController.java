package com.svlugovoy.eventsdemo.controller;

import com.svlugovoy.eventsdemo.domain.Book;
import com.svlugovoy.eventsdemo.event.BookSavedEvent;
import com.svlugovoy.eventsdemo.event.BooksShowedEvent;
import com.svlugovoy.eventsdemo.event.OneBookShowedEvent;
import com.svlugovoy.eventsdemo.repository.BookRepository;
import com.svlugovoy.eventsdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> findBooks() {
        List<Book> books = bookRepository.findAll();
        eventPublisher.publishEvent(new BooksShowedEvent(this, books));
        return books;
    }

    @GetMapping(path = "/{id}")
    public Book findBookById(@PathVariable String id) {
        Book book = bookRepository.findById(Long.valueOf(id)).get();
        eventPublisher.publishEvent(new OneBookShowedEvent(this, book));
        return book;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        eventPublisher.publishEvent(new BookSavedEvent(this, book));
        return savedBook;
    }

    @PostMapping("/two")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> createBook(@RequestBody List<Book> books) {
        List<Book> savedBooks = bookService.saveTwoBooks(books.get(0), books.get(1));
        return savedBooks;
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateBook(@PathVariable String id, @RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookRepository.deleteById(Long.valueOf(id));
    }

}
