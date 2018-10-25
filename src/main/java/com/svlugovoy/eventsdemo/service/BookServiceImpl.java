package com.svlugovoy.eventsdemo.service;

import com.svlugovoy.eventsdemo.domain.Book;
import com.svlugovoy.eventsdemo.event.BookSavedEvent;
import com.svlugovoy.eventsdemo.event.BookTransactionalSavedEvent;
import com.svlugovoy.eventsdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    @Override
    public List<Book> saveTwoBooks(Book book1, Book book2) {
        Book saved1 = bookRepository.save(book1);

        eventPublisher.publishEvent(new BookTransactionalSavedEvent(this, book1));

        Random random = new Random(); // simulated error
        if (random.nextBoolean()) {
            throw new RuntimeException("error");
        }

        Book saved2 = bookRepository.save(book2);

        return Arrays.asList(saved1, saved2);
    }
}
