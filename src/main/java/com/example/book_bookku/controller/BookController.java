package com.example.book_bookku.controller;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        Map<String, Object> response = new HashMap<>();
        ResponseEntity responseEntity = null;

        try {
            CompletableFuture<List<Book>> books = bookService.getAllBooks();

            response.put("status", HttpStatus.OK);
            response.put("message", "Success");
            response.put("data", books.get());
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            System.out.println("Error in get all books!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id){
        Map<String, Object> response = new HashMap<>();
        ResponseEntity responseEntity = null;

        try {
            CompletableFuture<Optional<Book>> book = bookService.getBookById(id);

            response.put("status", HttpStatus.OK);
            response.put("message", "Success");
            response.put("data", book.get());
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            System.out.println("Error in getting book!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable UUID id){
        bookService.deleteBookById(id);
        return "success";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable UUID id, @RequestBody Book book){
        Book newBook = bookService.editBook(id, book);
        return "success";
    }
}
