package com.flavv85.bookstorebe.controller;

import com.flavv85.bookstorebe.model.Book;
import com.flavv85.bookstorebe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "books")
public class BookController {

    private byte[] bytes;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get")
    public List<Book> getBooks() {
        return bookRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "name"));
    }

    // image bytes for the books
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }
    // delete book
    @DeleteMapping(path = {"/id"})
    public Book deleteBook(@PathVariable("id") long id){
        Book book = bookRepository.getById(id);
        bookRepository.deleteById(id);
        return book;
    }

    // save book details
    @PostMapping("/add")
    public void createBook(@RequestBody Book book) throws IOException {
        book.setPicByte(this.bytes);
        bookRepository.save(book);
        this.bytes = null;
    }


}
