package com.svlugovoy.eventsdemo.listener;

import com.svlugovoy.eventsdemo.event.BookSavedEvent;
import com.svlugovoy.eventsdemo.event.BookTransactionalSavedEvent;
import com.svlugovoy.eventsdemo.event.BooksShowedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class BookSaveTransactionalLogger {

    private static final String DASH_LINE = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    private static final String NEXT_LINE = "\n";

    @TransactionalEventListener
//    @EventListener
    public void onSaveTransactionalBook(BookTransactionalSavedEvent event) {
        log.info(NEXT_LINE + NEXT_LINE + DASH_LINE + NEXT_LINE +
                "[TRANSACTIONAL] Saved book with id={}, quantity of invocation save method = {}", event.getBook().getId(), "" +
                NEXT_LINE + DASH_LINE + NEXT_LINE);
    }


}
