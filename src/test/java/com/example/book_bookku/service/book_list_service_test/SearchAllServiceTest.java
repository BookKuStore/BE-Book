package com.example.book_bookku.service.book_list_service_test;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import com.example.book_bookku.service.book_list_services.KeywordService;
import com.example.book_bookku.service.book_list_services.KeywordWithFilterService;
import com.example.book_bookku.service.book_list_services.SearchAllService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringJUnitConfig
public class SearchAllServiceTest {

    @Autowired
    SearchAllService searchAllService;

    @MockBean
    KeywordService keywordService;

    @MockBean
    KeywordWithFilterService keywordWithFilterService;

    @MockBean
    BookRepository bookRepository;

    List<Book> books;

    @BeforeEach
    void setUp() {

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
                .setJudul("book 3")
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

        books.add(book1);
        books.add(book2);
        books.add(book3);

        searchAllService.setNextHandler(keywordService);
        keywordService.setNextHandler(keywordWithFilterService);

        when(bookRepository.findAll()).thenReturn(books);
    }

    @Test
    void testNextHandler() {
        assertEquals(keywordService, searchAllService.getNextHandler());
    }

    @Test
    void testKeywordIsNull() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        searchAllService.setKeyword(null);
        assertEquals(books, bookRepository.findAll());
    }

    @Test
    void testKeywordIsEmpty() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        searchAllService.setKeyword("");
        assertEquals(books, bookRepository.findAll());
    }
}