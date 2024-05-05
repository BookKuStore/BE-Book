package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
=======
import java.util.UUID;
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
public class BookRepositoryTest {
<<<<<<< HEAD
=======

>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
    @Autowired
    BookRepository bookRepository;

    List<Book> books;

    @BeforeEach
    void setUp() {
<<<<<<< HEAD
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
=======

        books = new ArrayList<>();

        Book book1 = Book.Builder.builder()
                .setId(UUID.fromString("c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0"))
                .setJudul("Buku 1")
                .setPenulis("Penulis 1")
                .setPenerbit("Penerbit 1")
                .setDeskripsi("Ini adalah buku pertama")
                .setHarga(100000)
                .setStok(10)
                .setTanggalTerbit(LocalDate.of(2001, Month.APRIL, 3))
                .setIsbn("1234567890123")
                .setJumlahHalaman(100)
                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
                        "ef8303f56910954f5e076")
                .setKategori("Fiksi")
                .build();

        Book book2 = Book.Builder.builder()
                .setId(UUID.fromString("3d2c8a7e-162f-4e44-bf88-6234e3a75fc7"))
                .setJudul("Buku 2")
                .setPenulis("Penulis 2")
                .setPenerbit("Penerbit 2")
                .setDeskripsi("Ini adalah buku kedua")
                .setHarga(200000)
                .setStok(20)
                .setTanggalTerbit(LocalDate.of(2002, Month.APRIL, 3))
                .setIsbn("1234567890234")
                .setJumlahHalaman(200)
                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
                        "ef8303f56910954f5e076")
                .setKategori("Petualangan")
                .build();

        Book book3 = Book.Builder.builder()
                .setId(UUID.fromString("8b1f2ba6-f24b-4e5d-ae28-2e07a6d1b63e"))
                .setJudul("Buku 3")
                .setPenulis("Penulis 3")
                .setPenerbit("Penerbit 3")
                .setDeskripsi("Ini adalah buku ketiga")
                .setHarga(300000)
                .setStok(30)
                .setTanggalTerbit(LocalDate.of(2003, Month.APRIL, 3))
                .setIsbn("1234567890345")
                .setJumlahHalaman(300)
                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
                        "ef8303f56910954f5e076")
                .setKategori("Pendidikan")
                .build();
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb

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
<<<<<<< HEAD
        assertEquals(book.getTanggalterbit(), findResult.getTanggalterbit());
        assertEquals(book.getIsbn(), findResult.getIsbn());
        assertEquals(book.getJumlahhalaman(), findResult.getJumlahhalaman());
        assertEquals(book.getFotocover(), findResult.getFotocover());
=======
        assertEquals(book.getTanggal_terbit(), findResult.getTanggal_terbit());
        assertEquals(book.getIsbn(), findResult.getIsbn());
        assertEquals(book.getJumlah_halaman(), findResult.getJumlah_halaman());
        assertEquals(book.getFoto_cover(), findResult.getFoto_cover());
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
        assertEquals(book.getKategori(), findResult.getKategori());
    }

    @Test
    void testSaveUpdate() {
        Book book = books.get(1);
        bookRepository.save(book);

<<<<<<< HEAD
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
=======
        Book newBook = Book.Builder.builder()
                .setId(book.getId())
                .setJudul(book.getJudul())
                .setPenulis(book.getPenulis())
                .setPenerbit(book.getPenerbit())
                .setDeskripsi("Ini adalah buku tengah")
                .setHarga(book.getHarga())
                .setStok(book.getStok())
                .setTanggalTerbit(book.getTanggal_terbit())
                .setIsbn(book.getIsbn())
                .setJumlahHalaman(book.getJumlah_halaman())
                .setFotoCover(book.getFoto_cover())
                .setKategori(book.getKategori())
                .build();
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb

        Book result = bookRepository.save(newBook);

        Optional<Book> optionalBook = bookRepository.findById(books.get(1).getId());
        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));

        assertEquals(book.getId(), result.getId());
        assertEquals(book.getId(), findResult.getId());
        assertEquals(book.getJudul(), findResult.getJudul());
        assertEquals(book.getPenulis(), findResult.getPenulis());
        assertEquals(book.getPenerbit(), findResult.getPenerbit());
<<<<<<< HEAD
        assertEquals("Ini adalah buku kedua", findResult.getDeskripsi());
        assertEquals(book.getHarga(),findResult.getHarga());
        assertEquals(book.getStok(), findResult.getStok());
        assertEquals(book.getTanggalterbit(), findResult.getTanggalterbit());
        assertEquals(book.getIsbn(), findResult.getIsbn());
        assertEquals(book.getJumlahhalaman(), findResult.getJumlahhalaman());
        assertEquals(book.getFotocover(), findResult.getFotocover());
=======
        assertEquals("Ini adalah buku tengah", findResult.getDeskripsi());
        assertEquals(book.getHarga(),findResult.getHarga());
        assertEquals(book.getStok(), findResult.getStok());
        assertEquals(book.getTanggal_terbit(), findResult.getTanggal_terbit());
        assertEquals(book.getIsbn(), findResult.getIsbn());
        assertEquals(book.getJumlah_halaman(), findResult.getJumlah_halaman());
        assertEquals(book.getFoto_cover(), findResult.getFoto_cover());
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
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
<<<<<<< HEAD
        assertEquals(books.get(1).getTanggalterbit(), findResult.getTanggalterbit());
        assertEquals(books.get(1).getIsbn(), findResult.getIsbn());
        assertEquals(books.get(1).getJumlahhalaman(), findResult.getJumlahhalaman());
        assertEquals(books.get(1).getFotocover(), findResult.getFotocover());
=======
        assertEquals(books.get(1).getTanggal_terbit(), findResult.getTanggal_terbit());
        assertEquals(books.get(1).getIsbn(), findResult.getIsbn());
        assertEquals(books.get(1).getJumlah_halaman(), findResult.getJumlah_halaman());
        assertEquals(books.get(1).getFoto_cover(), findResult.getFoto_cover());
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
        assertEquals(books.get(1).getKategori(), findResult.getKategori());
    }

    @Test
    void testFindByIdIfNotFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

<<<<<<< HEAD
        Optional<Book> optionalBook = bookRepository.findById(500);
        assertTrue(optionalBook.isEmpty());
    }
}
=======
        Optional<Book> optionalBook = bookRepository.findById(UUID.fromString("3d5c8a7e-162f-4e44-bf88-6234e3a75fc7"));
        assertTrue(optionalBook.isEmpty());
    }
}
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
