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
                1L,
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
        assertEquals(1L, book.getId());
        assertEquals("Judul Buku", book.getJudul());
        assertEquals("Penulis Buku", book.getPenulis());
        assertEquals("Penerbit Buku", book.getPenerbit());
        assertEquals("Deskripsi Buku", book.getDeskripsi());
        assertEquals(20, book.getHarga());
        assertEquals(100, book.getStok());
        assertEquals(LocalDate.now(), book.getTanggalTerbit());
        assertEquals("9780141199078", book.getISBN());
        assertEquals(279, book.getJumlahHalaman());
        assertEquals("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303" +
                "f56910954f5e076", book.getFotoCover());
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
        assertEquals(LocalDate.now(), partialBook.getTanggalTerbit());
        assertEquals("9780141199078", partialBook.getISBN());
        assertEquals(279, partialBook.getJumlahHalaman());
        assertEquals("https://example.com/foto_cover.jpg", partialBook.getFotoCover());
        assertEquals("Fiksi", partialBook.getKategori());
    }

    @Test
    public void testValidFotoCoverURL() {
        // Memeriksa apakah tautan foto cover valid
        assertTrue(isValidURL(book.getFotoCover()));
    }

    @Test
    public void testInvalidFotoCoverURL() {
        book.setFotoCover("not_a_valid_url");

        // Memeriksa apakah tautan foto cover tidak valid
        assertFalse(isValidURL(book.getFotoCover()));
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
