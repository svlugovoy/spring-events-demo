package com.svlugovoy.eventsdemo.listener;

import com.svlugovoy.eventsdemo.event.BookSavedEvent;
import com.svlugovoy.eventsdemo.event.BooksShowedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class BookActionLogger {

    private static Integer saveCounter = 0;
    private static Integer showAllCounter = 0;

    private static final String DASH_LINE = "===================================";
    private static final String NEXT_LINE = "\n";

    @EventListener
    @Async
    public void onSaveBook(BookSavedEvent event) {
        log.info(NEXT_LINE + NEXT_LINE + DASH_LINE + NEXT_LINE +
                "Saved book with id={}, quantity of invocation save method = {}", event.getBook().getId(), ++saveCounter +
                NEXT_LINE + DASH_LINE + NEXT_LINE);
    }

    @EventListener
    @Async
    public void onShowBooks(BooksShowedEvent event) {
        log.info(NEXT_LINE + NEXT_LINE + DASH_LINE + NEXT_LINE +
                "Showed {} books, quantity of invocation getAll method = {}", event.getBooks().size(), ++showAllCounter +
                NEXT_LINE + DASH_LINE + NEXT_LINE);
    }


}
