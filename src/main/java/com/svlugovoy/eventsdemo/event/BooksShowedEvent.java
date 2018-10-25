package com.svlugovoy.eventsdemo.event;

import com.svlugovoy.eventsdemo.domain.Book;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class BooksShowedEvent extends ApplicationEvent {

	private final List<Book> books;

	public BooksShowedEvent(Object source, List<Book> books) {
		super(source);
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	private static final long serialVersionUID = 2461738659888693744L;

}
