package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Async
    public CompletableFuture<List<Book>> getAllBooks() throws InterruptedException {
        List<Book> bookList = bookRepository.findAll();

        return CompletableFuture.completedFuture(bookList);
    }

    @Async
    public CompletableFuture<Optional<Book>> getBookById(UUID id){
        Optional<Book> book = bookRepository.findById(id);

        return CompletableFuture.completedFuture(book);
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(UUID id){
        bookRepository.deleteById(id);
    }
}
