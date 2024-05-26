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
                .setFotoCover("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076")
                .setKategori("Fiksi")
                .build();
    }

    @Test
    public void testBookConstructorAndGetters() {
        UUID id = UUID.randomUUID();
        String judul = "Judul Buku";
        String penulis = "Penulis Buku";
        String penerbit = "Penerbit Buku";
        String deskripsi = "Deskripsi Buku";
        int harga = 20;
        int stok = 100;
        LocalDate tanggalTerbit = LocalDate.of(2000, 4, 20);
        String isbn = "9780141199078";
        int jumlahHalaman = 300;
        String fotoCover = "https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076";
        String kategori = "Fiksi";

        Book book = new Book();
        book.setId(id);
        book.setJudul(judul);
        book.setPenulis(penulis);
        book.setPenerbit(penerbit);
        book.setDeskripsi(deskripsi);
        book.setHarga(harga);
        book.setStok(stok);
        book.setTanggal_terbit(tanggalTerbit);
        book.setIsbn(isbn);
        book.setJumlah_halaman(jumlahHalaman);
        book.setFoto_cover(fotoCover);
        book.setKategori(kategori);

        assertEquals(id, book.getId());
        assertEquals(judul, book.getJudul());
        assertEquals(penulis, book.getPenulis());
        assertEquals(penerbit, book.getPenerbit());
        assertEquals(deskripsi, book.getDeskripsi());
        assertEquals(harga, book.getHarga());
        assertEquals(stok, book.getStok());
        assertEquals(tanggalTerbit, book.getTanggal_terbit());
        assertEquals(isbn, book.getIsbn());
        assertEquals(jumlahHalaman, book.getJumlah_halaman());
        assertEquals(fotoCover, book.getFoto_cover());
        assertEquals(kategori, book.getKategori());
    }

    @Test
    public void testDefaultConstructor() {
        // Memastikan konstruktor default berfungsi dengan benar
        Book defaultBook = new Book();
        assertNotNull(defaultBook.getId());
        assertNull(defaultBook.getJudul());
        assertNull(defaultBook.getPenulis());
        assertNull(defaultBook.getPenerbit());
        assertNull(defaultBook.getDeskripsi());
        assertEquals(0, defaultBook.getHarga());
        assertEquals(0, defaultBook.getStok());
        assertNull(defaultBook.getTanggal_terbit());
        assertNull(defaultBook.getIsbn());
        assertEquals(0, defaultBook.getJumlah_halaman());
        assertNull(defaultBook.getFoto_cover());
        assertNull(defaultBook.getKategori());
        assertEquals(0, defaultBook.getBuy_count());
    }

    @Test
    public void testEqualsAndHashCode() {
        Book book = new Book();
        book.setJudul("Judul Buku");

        // Memeriksa apakah objek sama dengan dirinya sendiri
        assertEquals(book, book);
        assertEquals(book.hashCode(), book.hashCode());
    }

    @Test
    public void testToString() {
        UUID id = UUID.randomUUID();
        String judul = "Judul Buku";
        String penulis = "Penulis Buku";
        String penerbit = "Penerbit Buku";
        String deskripsi = "Deskripsi Buku";
        int harga = 20;
        int stok = 100;
        LocalDate tanggalTerbit = LocalDate.of(2000, 4, 20);
        String isbn = "9780141199078";
        int jumlahHalaman = 300;
        String fotoCover = "https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076";
        String kategori = "Fiksi";

        Book book = new Book();
        book.setId(id);
        book.setJudul(judul);
        book.setPenulis(penulis);
        book.setPenerbit(penerbit);
        book.setDeskripsi(deskripsi);
        book.setHarga(harga);
        book.setStok(stok);
        book.setTanggal_terbit(tanggalTerbit);
        book.setIsbn(isbn);
        book.setJumlah_halaman(jumlahHalaman);
        book.setFoto_cover(fotoCover);
        book.setKategori(kategori);

        String expectedString = "Book(id=" + id + ", judul=Judul Buku, penulis=Penulis Buku, penerbit=Penerbit Buku, deskripsi=Deskripsi Buku, harga=20, stok=100, tanggal_terbit=2000-04-20, isbn=9780141199078, jumlah_halaman=300, foto_cover=https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076, kategori=Fiksi, buy_count=0)";

        assertEquals(expectedString, book.toString());
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
        assertEquals("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076", book.getFoto_cover());
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

    @Test
    public void testSettersAndGetters() {
        // Memeriksa apakah setter dan getter yang dihasilkan oleh Lombok berfungsi dengan benar
        Book testBook = new Book();
        UUID id = UUID.randomUUID();
        testBook.setId(id);
        testBook.setJudul("New Title");
        testBook.setPenulis("New Author");
        testBook.setPenerbit("New Publisher");
        testBook.setDeskripsi("New Description");
        testBook.setHarga(30);
        testBook.setStok(50);
        testBook.setTanggal_terbit(LocalDate.of(2021, Month.JANUARY, 1));
        testBook.setIsbn("1234567890123");
        testBook.setJumlah_halaman(150);
        testBook.setFoto_cover("https://example.com/new_cover.jpg");
        testBook.setKategori("Non-Fiction");
        testBook.setBuy_count(10);

        assertEquals(id, testBook.getId());
        assertEquals("New Title", testBook.getJudul());
        assertEquals("New Author", testBook.getPenulis());
        assertEquals("New Publisher", testBook.getPenerbit());
        assertEquals("New Description", testBook.getDeskripsi());
        assertEquals(30, testBook.getHarga());
        assertEquals(50, testBook.getStok());
        assertEquals(LocalDate.of(2021, Month.JANUARY, 1), testBook.getTanggal_terbit());
        assertEquals("1234567890123", testBook.getIsbn());
        assertEquals(150, testBook.getJumlah_halaman());
        assertEquals("https://example.com/new_cover.jpg", testBook.getFoto_cover());
        assertEquals("Non-Fiction", testBook.getKategori());
        assertEquals(10, testBook.getBuy_count());
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
