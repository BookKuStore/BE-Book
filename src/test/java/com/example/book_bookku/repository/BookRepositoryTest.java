//package com.example.book_bookku.repository;
//
//import com.example.book_bookku.model.Book;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@SpringJUnitConfig
//public class BookRepositoryTest {
//
//    @Autowired
//    BookRepository bookRepository;
//
//    List<Book> books;
//
//    @BeforeEach
//    void setUp() {
//
//        books = new ArrayList<>();
//
//        Book book1 = Book.Builder.builder()
//                .setId(UUID.fromString("c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0"))
//                .setJudul("Buku 1")
//                .setPenulis("Penulis 1")
//                .setPenerbit("Penerbit 1")
//                .setDeskripsi("Ini adalah buku pertama")
//                .setHarga(100000)
//                .setStok(10)
//                .setTanggalTerbit(LocalDate.of(2001, Month.APRIL, 3))
//                .setIsbn("1234567890123")
//                .setJumlahHalaman(100)
//                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
//                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
//                        "ef8303f56910954f5e076")
//                .setKategori("Fiksi")
//                .build();
//
//        Book book2 = Book.Builder.builder()
//                .setId(UUID.fromString("3d2c8a7e-162f-4e44-bf88-6234e3a75fc7"))
//                .setJudul("Buku 2")
//                .setPenulis("Penulis 2")
//                .setPenerbit("Penerbit 2")
//                .setDeskripsi("Ini adalah buku kedua")
//                .setHarga(200000)
//                .setStok(20)
//                .setTanggalTerbit(LocalDate.of(2002, Month.APRIL, 3))
//                .setIsbn("1234567890234")
//                .setJumlahHalaman(200)
//                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
//                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
//                        "ef8303f56910954f5e076")
//                .setKategori("Petualangan")
//                .build();
//
//        Book book3 = Book.Builder.builder()
//                .setId(UUID.fromString("8b1f2ba6-f24b-4e5d-ae28-2e07a6d1b63e"))
//                .setJudul("Buku 3")
//                .setPenulis("Penulis 3")
//                .setPenerbit("Penerbit 3")
//                .setDeskripsi("Ini adalah buku ketiga")
//                .setHarga(300000)
//                .setStok(30)
//                .setTanggalTerbit(LocalDate.of(2003, Month.APRIL, 3))
//                .setIsbn("1234567890345")
//                .setJumlahHalaman(300)
//                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
//                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
//                        "ef8303f56910954f5e076")
//                .setKategori("Pendidikan")
//                .build();
//
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//    }
//
//    @Test
//    void testSaveCreate() {
//        Book book = books.get(0);
//        Book result = bookRepository.save(book);
//
//        Optional<Book> optionalBook = bookRepository.findById(books.get(0).getId());
//        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));
//
//        assertEquals(book.getId(), result.getId());
//        assertEquals(book.getId(), findResult.getId());
//        assertEquals(book.getJudul(), findResult.getJudul());
//        assertEquals(book.getPenulis(), findResult.getPenulis());
//        assertEquals(book.getPenerbit(), findResult.getPenerbit());
//        assertEquals(book.getDeskripsi(), findResult.getDeskripsi());
//        assertEquals(book.getHarga(),findResult.getHarga());
//        assertEquals(book.getStok(), findResult.getStok());
//        assertEquals(book.getTanggal_terbit(), findResult.getTanggal_terbit());
//        assertEquals(book.getIsbn(), findResult.getIsbn());
//        assertEquals(book.getJumlah_halaman(), findResult.getJumlah_halaman());
//        assertEquals(book.getFoto_cover(), findResult.getFoto_cover());
//        assertEquals(book.getKategori(), findResult.getKategori());
//    }
//
//    @Test
//    void testSaveUpdate() {
//        Book book = books.get(1);
//        bookRepository.save(book);
//
//        Book newBook = Book.Builder.builder()
//                .setId(book.getId())
//                .setJudul(book.getJudul())
//                .setPenulis(book.getPenulis())
//                .setPenerbit(book.getPenerbit())
//                .setDeskripsi("Ini adalah buku tengah")
//                .setHarga(book.getHarga())
//                .setStok(book.getStok())
//                .setTanggalTerbit(book.getTanggal_terbit())
//                .setIsbn(book.getIsbn())
//                .setJumlahHalaman(book.getJumlah_halaman())
//                .setFotoCover(book.getFoto_cover())
//                .setKategori(book.getKategori())
//                .build();
//
//        Book result = bookRepository.save(newBook);
//
//        Optional<Book> optionalBook = bookRepository.findById(books.get(1).getId());
//        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));
//
//        assertEquals(book.getId(), result.getId());
//        assertEquals(book.getId(), findResult.getId());
//        assertEquals(book.getJudul(), findResult.getJudul());
//        assertEquals(book.getPenulis(), findResult.getPenulis());
//        assertEquals(book.getPenerbit(), findResult.getPenerbit());
//        assertEquals("Ini adalah buku tengah", findResult.getDeskripsi());
//        assertEquals(book.getHarga(),findResult.getHarga());
//        assertEquals(book.getStok(), findResult.getStok());
//        assertEquals(book.getTanggal_terbit(), findResult.getTanggal_terbit());
//        assertEquals(book.getIsbn(), findResult.getIsbn());
//        assertEquals(book.getJumlah_halaman(), findResult.getJumlah_halaman());
//        assertEquals(book.getFoto_cover(), findResult.getFoto_cover());
//        assertEquals(book.getKategori(), findResult.getKategori());
//    }
//
//    @Test
//    void testFindByIdIfFound() {
//        for (Book book : books) {
//            bookRepository.save(book);
//        }
//
//        Optional<Book> optionalBook = bookRepository.findById(books.get(1).getId());
//        Book findResult = optionalBook.orElseThrow(() -> new RuntimeException("Book not found"));
//
//        assertEquals(books.get(1).getId(), findResult.getId());
//        assertEquals(books.get(1).getJudul(), findResult.getJudul());
//        assertEquals(books.get(1).getPenulis(), findResult.getPenulis());
//        assertEquals(books.get(1).getPenerbit(), findResult.getPenerbit());
//        assertEquals(books.get(1).getDeskripsi(), findResult.getDeskripsi());
//        assertEquals(books.get(1).getHarga(),findResult.getHarga());
//        assertEquals(books.get(1).getStok(), findResult.getStok());
//        assertEquals(books.get(1).getTanggal_terbit(), findResult.getTanggal_terbit());
//        assertEquals(books.get(1).getIsbn(), findResult.getIsbn());
//        assertEquals(books.get(1).getJumlah_halaman(), findResult.getJumlah_halaman());
//        assertEquals(books.get(1).getFoto_cover(), findResult.getFoto_cover());
//        assertEquals(books.get(1).getKategori(), findResult.getKategori());
//    }
//
//    @Test
//    void testFindByIdIfNotFound() {
//        for (Book book : books) {
//            bookRepository.save(book);
//        }
//
//        Optional<Book> optionalBook = bookRepository.findById(UUID.fromString("3d5c8a7e-162f-4e44-bf88-6234e3a75fc7"));
//        assertTrue(optionalBook.isEmpty());
//    }
//}