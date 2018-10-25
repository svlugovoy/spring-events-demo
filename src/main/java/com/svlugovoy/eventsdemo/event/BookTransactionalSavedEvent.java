package com.svlugovoy.eventsdemo.event;

import com.svlugovoy.eventsdemo.domain.Book;
import org.springframework.context.ApplicationEvent;

public class BookTransactionalSavedEvent extends ApplicationEvent {

	private final Book book;

	public BookTransactionalSavedEvent(Object source, Book book) {
		super(source);
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}

	private static final long serialVersionUID = 2461738659856693744L;

}
