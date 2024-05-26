package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class BookService {
    private BookRepository bookRepository;

//    @Autowired
//    public BookService(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }


    public List<Book> getAllBooks() throws InterruptedException {
        List<Book> bookList = bookRepository.findAll();

        return bookList;
    }

    public Optional<Book> getBookById(UUID id){
        Optional<Book> book = bookRepository.findById(id);

        return book;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(UUID id){
        Book book = bookRepository.getReferenceById(id);

        if(book.getBuy_count() != 0 ){
            throw new Error("Cannot delete book");
        }

        bookRepository.deleteById(id);
    }

    public Book editBook(UUID id, Book book) {
        Book editedBook = bookRepository.getReferenceById(id);
        editedBook.setPenerbit(book.getPenerbit());
        editedBook.setDeskripsi(book.getDeskripsi());
        editedBook.setHarga(book.getHarga());
        editedBook.setStok(book.getStok());
        editedBook.setTanggal_terbit(book.getTanggal_terbit());
        editedBook.setIsbn(book.getIsbn());
        editedBook.setJumlah_halaman(book.getJumlah_halaman());
        editedBook.setFoto_cover(book.getFoto_cover());
        editedBook.setKategori(book.getKategori());
        editedBook.setBuy_count(book.getBuy_count());

        return bookRepository.save(editedBook);
    }

    public Book bookBought(UUID id, int quantity){
        Book boughtBook = bookRepository.getReferenceById(id);
        boughtBook.setBuy_count(boughtBook.getBuy_count() + quantity);

        return bookRepository.save(boughtBook);
    }

}