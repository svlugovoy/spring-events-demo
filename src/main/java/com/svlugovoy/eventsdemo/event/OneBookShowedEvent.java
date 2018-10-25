package com.svlugovoy.eventsdemo.event;

import com.svlugovoy.eventsdemo.domain.Book;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class OneBookShowedEvent extends ApplicationEvent {

	private final Book book;

	public OneBookShowedEvent(Object source, Book book) {
		super(source);
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	private static final long serialVersionUID = 2461738644888693744L;

}
