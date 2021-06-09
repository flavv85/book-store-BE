package com.flavv85.bookstorebe.repository;

import com.flavv85.bookstorebe.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
