package org.book.springbootbookseller.repository;

import org.book.springbootbookseller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {



}
