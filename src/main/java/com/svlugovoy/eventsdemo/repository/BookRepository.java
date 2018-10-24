package com.svlugovoy.eventsdemo.repository;

import com.svlugovoy.eventsdemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
