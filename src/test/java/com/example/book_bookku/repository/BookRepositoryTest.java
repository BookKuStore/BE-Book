package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    List<Book> books;

    @BeforeEach
    void setUp() {
//        bookRepository = new BookRepository();

        books = new ArrayList<>();
        Book book1 = new Book(
                1,
                "Buku 1",
                "Penulis 1",
                "Penerbit 1",
                "Ini adalah buku pertama",
                100000,
                10,
                LocalDate.of(2001, Month.APRIL, 3),
                "1234567890123",
                100,
                "https://www.google.com/",
                "Fiksi");

        Book book2 = new Book(2,
                "Buku 2",
                "Penulis 2",
                "Penerbit 2",
                "Ini adalah buku kedua",
                200000,
                20,
                LocalDate.of(2002, Month.APRIL, 3),
                "1234567890234",
                200,
                "https://www.youtube.com/",
                "Aksi");

        Book book3 = new Book(3,
                "Buku 3",
                "Penulis 3",
                "Penerbit 3",
                "Ini adalah buku ketiga",
                300000,
                30,
                LocalDate.of(2003, Month.APRIL, 3),
                "1234567890345",
                300,
                "https://scele.cs.ui.ac.id/",
                "Pendidikan");

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    @Test
    void testSaveCreate() {
        Book book = books.get(0);
        Book result = bookRepository.save(book);

        Optional<Book> optionalBook = bookRepository.findById(books.get(0).getId());
        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));

        assertEquals(book.getId(), result.getId());
        assertEquals(book.getId(), findResult.getId());
        assertEquals(book.getJudul(), findResult.getJudul());
        assertEquals(book.getPenulis(), findResult.getPenulis());
        assertEquals(book.getPenerbit(), findResult.getPenerbit());
        assertEquals(book.getDeskripsi(), findResult.getDeskripsi());
        assertEquals(book.getHarga(),findResult.getHarga());
        assertEquals(book.getStok(), findResult.getStok());
        assertEquals(book.getTanggalterbit(), findResult.getTanggalterbit());
        assertEquals(book.getIsbn(), findResult.getIsbn());
        assertEquals(book.getJumlahhalaman(), findResult.getJumlahhalaman());
        assertEquals(book.getFotocover(), findResult.getFotocover());
        assertEquals(book.getKategori(), findResult.getKategori());
    }

    @Test
    void testSaveUpdate() {
        Book book = books.get(1);
        bookRepository.save(book);

        Book newBook = new Book(
                book.getId(),
                book.getJudul(),
                book.getPenulis(),
                book.getPenerbit(),
                "Ini adalah buku kedua",
                book.getHarga(),
                book.getStok(),
                book.getTanggalterbit(),
                book.getIsbn(),
                book.getJumlahhalaman(),
                book.getFotocover(),
                book.getKategori());

        Book result = bookRepository.save(newBook);

        Optional<Book> optionalBook = bookRepository.findById(books.get(1).getId());
        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));

        assertEquals(book.getId(), result.getId());
        assertEquals(book.getId(), findResult.getId());
        assertEquals(book.getJudul(), findResult.getJudul());
        assertEquals(book.getPenulis(), findResult.getPenulis());
        assertEquals(book.getPenerbit(), findResult.getPenerbit());
        assertEquals("Ini adalah buku kedua", findResult.getDeskripsi());
        assertEquals(book.getHarga(),findResult.getHarga());
        assertEquals(book.getStok(), findResult.getStok());
        assertEquals(book.getTanggalterbit(), findResult.getTanggalterbit());
        assertEquals(book.getIsbn(), findResult.getIsbn());
        assertEquals(book.getJumlahhalaman(), findResult.getJumlahhalaman());
        assertEquals(book.getFotocover(), findResult.getFotocover());
        assertEquals(book.getKategori(), findResult.getKategori());
    }

    @Test
    void testFindByIdIfFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        Optional<Book> optionalBook = bookRepository.findById(books.get(1).getId());
        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));

        assertEquals(books.get(1).getId(), findResult.getId());
        assertEquals(books.get(1).getJudul(), findResult.getJudul());
        assertEquals(books.get(1).getPenulis(), findResult.getPenulis());
        assertEquals(books.get(1).getPenerbit(), findResult.getPenerbit());
        assertEquals(books.get(1).getDeskripsi(), findResult.getDeskripsi());
        assertEquals(books.get(1).getHarga(),findResult.getHarga());
        assertEquals(books.get(1).getStok(), findResult.getStok());
        assertEquals(books.get(1).getTanggalterbit(), findResult.getTanggalterbit());
        assertEquals(books.get(1).getIsbn(), findResult.getIsbn());
        assertEquals(books.get(1).getJumlahhalaman(), findResult.getJumlahhalaman());
        assertEquals(books.get(1).getFotocover(), findResult.getFotocover());
        assertEquals(books.get(1).getKategori(), findResult.getKategori());
    }

    @Test
    void testFindByIdIfNotFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        Optional<Book> optionalBook = bookRepository.findById(500);
        assertTrue(optionalBook.isEmpty());
    }
}
