package com.svlugovoy.eventsdemo.listener;

import com.svlugovoy.eventsdemo.event.BookSavedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BookActionLogger {

    @EventListener
    @Async
    public void onSaveBook(BookSavedEvent event) {
        System.out.println("\n\nSaved book with id = " + event.getBook().getId() + "\n\n");
    }
}
