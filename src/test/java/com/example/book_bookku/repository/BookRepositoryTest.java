package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    BookRepository bookRepository;
    List<Book> books;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();

        books = new ArrayList<>();
        Book book1 = new Book(
                1L,
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

        Book book2 = new Book(2L,
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

        Book book3 = new Book(3L,
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
        Book book = books.get(1);
        Book result = bookRepository.save(book);

        Book findResult = bookRepository.findById(String.valueOf(books.get(1).getId()));
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getId(), findResult.getId());
        assertEquals(book.getJudul(), findResult.getJudul());
        assertEquals(book.getPenulis(), findResult.getPenulis());
        assertEquals(book.getPenerbit(), findResult.getPenerbit());
        assertEquals(book.getDeskripsi(), findResult.getDeskripsi());
        assertEquals(book.getHarga(),findResult.getHarga());
        assertEquals(book.getStok(), findResult.getStok());
        assertEquals(book.getTanggalTerbit(), findResult.getTanggalTerbit());
        assertEquals(book.getISBN(), findResult.getISBN());
        assertEquals(book.getJumlahHalaman(), findResult.getJumlahHalaman());
        assertEquals(book.getFotoCover(), findResult.getFotoCover());
        assertEquals(book.getKategori(), findResult.getKategori());
    }

    @Test
    void testSaveUpdate() {
        Book book = books.get(2);
        bookRepository.save(book);
        Book newBook = new Book(
                book.getId(),
                book.getJudul(),
                book.getPenulis(),
                book.getPenerbit(),
                "Ini adalah buku terakhir",
                book.getHarga(),
                book.getStok(),
                book.getTanggalTerbit(),
                book.getISBN(),
                book.getJumlahHalaman(),
                book.getFotoCover(),
                book.getKategori());
        Book result = bookRepository.save(newBook);

        Book findResult = bookRepository.findById(books.get(2).getId());
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getId(), findResult.getId());
        assertEquals(book.getJudul(), findResult.getJudul());
        assertEquals(book.getPenulis(), findResult.getPenulis());
        assertEquals(book.getPenerbit(), findResult.getPenerbit());
        assertEquals("Ini adalah buku terakhi", findResult.getDeskripsi());
        assertEquals(book.getHarga(),findResult.getHarga());
        assertEquals(book.getStok(), findResult.getStok());
        assertEquals(book.getTanggalTerbit(), findResult.getTanggalTerbit());
        assertEquals(book.getISBN(), findResult.getISBN());
        assertEquals(book.getJumlahHalaman(), findResult.getJumlahHalaman());
        assertEquals(book.getFotoCover(), findResult.getFotoCover());
        assertEquals(book.getKategori(), findResult.getKategori());
    }

    @Test
    void testFindByIdIfFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        Book findResult = bookRepository.findById(String.valueOf(books.get(1).getId()));
        assertEquals(books.get(1).getId(), findResult.getId());
        assertEquals(books.get(1).getJudul(), findResult.getJudul());
        assertEquals(books.get(1).getPenulis(), findResult.getPenulis());
        assertEquals(books.get(1).getPenerbit(), findResult.getPenerbit());
        assertEquals(books.get(1).getDeskripsi(), findResult.getDeskripsi());
        assertEquals(books.get(1).getHarga(),findResult.getHarga());
        assertEquals(books.get(1).getStok(), findResult.getStok());
        assertEquals(books.get(1).getTanggalTerbit(), findResult.getTanggalTerbit());
        assertEquals(books.get(1).getISBN(), findResult.getISBN());
        assertEquals(books.get(1).getJumlahHalaman(), findResult.getJumlahHalaman());
        assertEquals(books.get(1).getFotoCover(), findResult.getFotoCover());
        assertEquals(books.get(1).getKategori(), findResult.getKategori());
    }

    @Test
    void testFindByIdIfNotFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        Book findResult = bookRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test
    void testFindAllByAuthorIfAuthorCorrect() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        List<Book> bookList = bookRepository.findAllByAuthor(
                books.get(1).getPenulis());
        assertEquals(2, bookList.size());
    }

    @Test
    void testFindAllByAuthorIfAllLowercase() {
        bookRepository.save(books.get(1));

        List<Book> bookList = bookRepository.findAllByAuthor(
                books.get(1).getPenulis().toLowerCase());
        assertTrue(bookList.isEmpty());
    }
}
