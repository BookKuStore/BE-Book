package com.example.book_bookku.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {

        // Membuat objek buku baru untuk setiap pengujian
        book = Book.Builder.builder()
                .setId(UUID.fromString("c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0"))
                .setJudul("Judul Buku")
                .setPenulis("Penulis Buku")
                .setPenerbit("Penerbit Buku")
                .setDeskripsi("Deskripsi Buku")
                .setHarga(20)
                .setStok(100)
                .setTanggalTerbit(LocalDate.of(2000, Month.APRIL, 20))
                .setIsbn("9780141199078")
                .setJumlahHalaman(300)
                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                        "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986" +
                        "ef8303f56910954f5e076")
                .setKategori("Fiksi")
                .build();
    }

    @Test
    public void testBookConstructorWithAllArguments() {
        // Memastikan constructor dengan semua argumen berfungsi dengan benar
        assertEquals(UUID.fromString("c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0"), book.getId());
        assertEquals("Judul Buku", book.getJudul());
        assertEquals("Penulis Buku", book.getPenulis());
        assertEquals("Penerbit Buku", book.getPenerbit());
        assertEquals("Deskripsi Buku", book.getDeskripsi());
        assertEquals(20, book.getHarga());
        assertEquals(100, book.getStok());
        assertEquals(LocalDate.of(2000, Month.APRIL, 20), book.getTanggal_terbit());
        assertEquals("9780141199078", book.getIsbn());
        assertEquals(300, book.getJumlah_halaman());
        assertEquals("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561." +
                "jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303" +
                "f56910954f5e076", book.getFoto_cover());
        assertEquals("Fiksi", book.getKategori());
    }

    @Test
    public void testBookConstructorWithPartialArguments() {
        // Memastikan constructor dengan beberapa argumen berfungsi dengan benar
        Book partialBook = Book.Builder.builder()
                .setJudul("Judul Buku")
                .setPenulis("Penulis Buku")
                .setPenerbit("Penerbit Buku")
                .setDeskripsi("Deskripsi Buku")
                .setHarga(20)
                .setStok(100)
                .setTanggalTerbit(LocalDate.of(2000, Month.APRIL, 20))
                .setIsbn("9780141199078")
                .setJumlahHalaman(300)
                .setFotoCover("https://example.com/foto_cover.jpg")
                .setKategori("Fiksi")
                .build();

        assertEquals("Judul Buku", partialBook.getJudul());
        assertEquals("Penulis Buku", partialBook.getPenulis());
        assertEquals("Penerbit Buku", partialBook.getPenerbit());
        assertEquals("Deskripsi Buku", partialBook.getDeskripsi());
        assertEquals(20, partialBook.getHarga());
        assertEquals(100, partialBook.getStok());
        assertEquals(LocalDate.of(2000, Month.APRIL, 20), partialBook.getTanggal_terbit());
        assertEquals("9780141199078", partialBook.getIsbn());
        assertEquals(300, partialBook.getJumlah_halaman());
        assertEquals("https://example.com/foto_cover.jpg", partialBook.getFoto_cover());
        assertEquals("Fiksi", partialBook.getKategori());
    }

    @Test
    public void testValidFotoCoverURL() {
        // Memeriksa apakah tautan foto cover valid
        assertTrue(isValidURL(book.getFoto_cover()));
    }

    @Test
    public void testInvalidFotoCoverURL() {
        book.setFoto_cover("not_a_valid_url");

        // Memeriksa apakah tautan foto cover tidak valid
        assertFalse(isValidURL(book.getFoto_cover()));
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