package com.flavv85.bookstorebe.controller;

import com.flavv85.bookstorebe.model.Book;
import com.flavv85.bookstorebe.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/get")
    public List<Book> getBooks(){
        return bookRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "name"));
    }

}
