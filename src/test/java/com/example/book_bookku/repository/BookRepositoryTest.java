package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest
//@SpringJUnitConfig
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    private Book testBook;

    @BeforeEach
    void setUp() {

        testBook = Book.Builder.builder()
                .setId(UUID.fromString("56b789bf-19b9-4c6b-b54a-7d65a2a0ad41"))
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
        bookRepository.save(testBook);
    }

    @Test
    void testFindByIdWhenSaved() {
        Book savedBook = bookRepository.findById(testBook.getId()).orElse(null);

        assertNotNull(savedBook);
        assertEquals(testBook.getId(), savedBook.getId());
        assertEquals(testBook.getId(), savedBook.getId());
        assertEquals(testBook.getJudul(), savedBook.getJudul());
        assertEquals(testBook.getPenulis(), savedBook.getPenulis());
        assertEquals(testBook.getPenerbit(), savedBook.getPenerbit());
        assertEquals(testBook.getDeskripsi(), savedBook.getDeskripsi());
        assertEquals(testBook.getHarga(),savedBook.getHarga());
        assertEquals(testBook.getStok(), savedBook.getStok());
        assertEquals(testBook.getTanggal_terbit(), savedBook.getTanggal_terbit());
        assertEquals(testBook.getIsbn(), savedBook.getIsbn());
        assertEquals(testBook.getJumlah_halaman(), savedBook.getJumlah_halaman());
        assertEquals(testBook.getFoto_cover(), savedBook.getFoto_cover());
        assertEquals(testBook.getKategori(), savedBook.getKategori());
    }

    @Test
    void testSaveUpdate() {
        testBook.setJudul("Judul Test 1");
        bookRepository.save(testBook);

        Book updatedBook = bookRepository.findById(testBook.getId()).orElse(null);

        assertNotNull(updatedBook);

        assertEquals("Judul Test 1", updatedBook.getJudul());
    }

    @AfterEach
    public void tearDown(){
        bookRepository.delete(testBook);
    }
}