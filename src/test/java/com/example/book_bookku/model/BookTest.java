package com.example.book_bookku.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        // Membuat objek buku baru untuk setiap pengujian
        book = new Book(
                1,
                "Judul Buku",
                "Penulis Buku",
                "Penerbit Buku",
                "Deskripsi Buku",
                20,
                100,
                LocalDate.now(),
                "9780141199078",
                279,
                "https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
                        "ef8303f56910954f5e076",
                "Fiksi"
        );
    }

    @Test
    public void testBookConstructorWithAllArguments() {
        // Memastikan constructor dengan semua argumen berfungsi dengan benar
        assertEquals(1, book.getId());
        assertEquals("Judul Buku", book.getJudul());
        assertEquals("Penulis Buku", book.getPenulis());
        assertEquals("Penerbit Buku", book.getPenerbit());
        assertEquals("Deskripsi Buku", book.getDeskripsi());
        assertEquals(20, book.getHarga());
        assertEquals(100, book.getStok());
        assertEquals(LocalDate.now(), book.getTanggalterbit());
        assertEquals("9780141199078", book.getIsbn());
        assertEquals(279, book.getJumlahhalaman());
        assertEquals("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303" +
                "f56910954f5e076", book.getFotocover());
        assertEquals("Fiksi", book.getKategori());
    }

    @Test
    public void testBookConstructorWithPartialArguments() {
        // Memastikan constructor dengan beberapa argumen berfungsi dengan benar
        Book partialBook = new Book("Judul Buku", "Penulis Buku", "Penerbit Buku", "Deskripsi Buku", 20, 100, LocalDate.now(), "9780141199078", 279, "https://example.com/foto_cover.jpg", "Fiksi");

        assertEquals("Judul Buku", partialBook.getJudul());
        assertEquals("Penulis Buku", partialBook.getPenulis());
        assertEquals("Penerbit Buku", partialBook.getPenerbit());
        assertEquals("Deskripsi Buku", partialBook.getDeskripsi());
        assertEquals(20, partialBook.getHarga());
        assertEquals(100, partialBook.getStok());
        assertEquals(LocalDate.now(), partialBook.getTanggalterbit());
        assertEquals("9780141199078", partialBook.getIsbn());
        assertEquals(279, partialBook.getJumlahhalaman());
        assertEquals("https://example.com/foto_cover.jpg", partialBook.getFotocover());
        assertEquals("Fiksi", partialBook.getKategori());
    }

    @Test
    public void testValidFotoCoverURL() {
        // Memeriksa apakah tautan foto cover valid
        assertTrue(isValidURL(book.getFotocover()));
    }

    @Test
    public void testInvalidFotoCoverURL() {
        book.setFotocover("not_a_valid_url");

        // Memeriksa apakah tautan foto cover tidak valid
        assertFalse(isValidURL(book.getFotocover()));
    }

    // Metode untuk memeriksa apakah suatu string adalah URL yang valid
    private boolean isValidURL(String url) {
        try {
            // Membuat objek URI dari string URL
            URI uri = new URI(url);
            // Memeriksa apakah URI valid
            return uri.isAbsolute();
        } catch (URISyntaxException e) {
            // Jika terjadi URISyntaxException, URL tidak valid
            return false;
        }
    }
}
