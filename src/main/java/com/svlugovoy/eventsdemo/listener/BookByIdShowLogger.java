package com.svlugovoy.eventsdemo.listener;

import com.svlugovoy.eventsdemo.event.BookSavedEvent;
import com.svlugovoy.eventsdemo.event.BooksShowedEvent;
import com.svlugovoy.eventsdemo.event.OneBookShowedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookByIdShowLogger implements ApplicationListener<OneBookShowedEvent> {

    private static final String DASH_LINE = "*****************************";
    private static final String NEXT_LINE = "\n";

    @Override
    public void onApplicationEvent(OneBookShowedEvent event) {
            log.info(NEXT_LINE + NEXT_LINE + DASH_LINE + NEXT_LINE +
                    "Book with id={} was showed", event.getBook().getId(), "" +
                    NEXT_LINE + DASH_LINE + NEXT_LINE);
    }
}
