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

    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        book1 = Book.Builder.builder()
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

        book2 = Book.Builder.builder()
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
    public void testEqualsReflexive() {
        assertEquals(book1, book1, "Equals should be reflexive");
    }

    @Test
    public void testEqualsSymmetric() {
        assertEquals(book1, book2, "Equals should be symmetric");
        assertEquals(book2, book1, "Equals should be symmetric");
    }

    @Test
    public void testEqualsTransitive() {
        Book book3 = Book.Builder.builder()
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

        assertEquals(book1, book2, "Equals should be transitive");
        assertEquals(book2, book3, "Equals should be transitive");
        assertEquals(book1, book3, "Equals should be transitive");
    }

    @Test
    public void testEqualsConsistent() {
        assertEquals(book1, book2, "Equals should be consistent");
        assertEquals(book1, book2, "Equals should be consistent");
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(book1, null, "Equals should return false for null comparison");
    }

    @Test
    public void testEqualsDifferentClass() {
        assertNotEquals(book1, "Some String", "Equals should return false for different class comparison");
    }

    @Test
    public void testEqualsDifferentId() {
        Book bookWithDifferentId = Book.Builder.builder()
                .setId(UUID.fromString("d7c8f81e-6c77-4f5e-bf8d-c1eaa4eafb2e"))
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

        assertNotEquals(book1, bookWithDifferentId, "Equals should return false for different id comparison");
    }

    @Test
    public void testEqualsDifferentFields() {
        Book bookWithDifferentFields = Book.Builder.builder()
                .setId(UUID.fromString("c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0"))
                .setJudul("Judul Berbeda")
                .setPenulis("Penulis Berbeda")
                .setPenerbit("Penerbit Berbeda")
                .setDeskripsi("Deskripsi Berbeda")
                .setHarga(30)
                .setStok(200)
                .setTanggalTerbit(LocalDate.of(2010, Month.MARCH, 15))
                .setIsbn("9781234567890")
                .setJumlahHalaman(400)
                .setFotoCover("https://example.com/berbeda.jpg")
                .setKategori("Non-Fiksi")
                .build();

        assertNotEquals(book1, bookWithDifferentFields, "Equals should return false for different field values comparison");
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
        assertEquals(UUID.fromString("c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0"), book1.getId());
        assertEquals("Judul Buku", book1.getJudul());
        assertEquals("Penulis Buku", book1.getPenulis());
        assertEquals("Penerbit Buku", book1.getPenerbit());
        assertEquals("Deskripsi Buku", book1.getDeskripsi());
        assertEquals(20, book1.getHarga());
        assertEquals(100, book1.getStok());
        assertEquals(LocalDate.of(2000, Month.APRIL, 20), book1.getTanggal_terbit());
        assertEquals("9780141199078", book1.getIsbn());
        assertEquals(300, book1.getJumlah_halaman());
        assertEquals("https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076", book1.getFoto_cover());
        assertEquals("Fiksi", book1.getKategori());
    }

    @Test
    public void testBookConstructorWithPartialArguments() {
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
        assertTrue(isValidURL(book1.getFoto_cover()));
    }

    @Test
    public void testInvalidFotoCoverURL() {
        book1.setFoto_cover("not_a_valid_url");
        assertFalse(isValidURL(book1.getFoto_cover()));
    }

    @Test
    public void testSettersAndGetters() {
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

    private boolean isValidURL(String url) {
        try {
            URI uri = new URI(url);
            return uri.isAbsolute();
        } catch (URISyntaxException e) {
            return false;
        }
    }

    @Test
    public void testHashCodeConsistency() {
        assertEquals(book1.hashCode(), book2.hashCode(), "Hash codes should be consistent for equal objects");
    }

    @Test
    public void testGettersAndSetters() {
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

    @Test
    public void testBuilderWithEdgeCases() {
        Book edgeCaseBook = Book.Builder.builder()
                .setJudul("")
                .setPenulis(null)
                .setPenerbit("")
                .setDeskripsi(null)
                .setHarga(Integer.MAX_VALUE)
                .setStok(Integer.MIN_VALUE)
                .setTanggalTerbit(LocalDate.of(9999, Month.DECEMBER, 31))
                .setIsbn("")
                .setJumlahHalaman(0)
                .setFotoCover("")
                .setKategori(null)
                .build();

        assertEquals("", edgeCaseBook.getJudul());
        assertNull(edgeCaseBook.getPenulis());
        assertEquals("", edgeCaseBook.getPenerbit());
        assertNull(edgeCaseBook.getDeskripsi());
        assertEquals(Integer.MAX_VALUE, edgeCaseBook.getHarga());
        assertEquals(Integer.MIN_VALUE, edgeCaseBook.getStok());
        assertEquals(LocalDate.of(9999, Month.DECEMBER, 31), edgeCaseBook.getTanggal_terbit());
        assertEquals("", edgeCaseBook.getIsbn());
        assertEquals(0, edgeCaseBook.getJumlah_halaman());
        assertEquals("", edgeCaseBook.getFoto_cover());
        assertNull(edgeCaseBook.getKategori());
    }

    @Test
    public void testToStringWithDifferentValues() {
        book1.setBuy_count(5);
        String expectedString = "Book(id=c68d81bf-9cd6-4a51-8c5e-c5e107bfb6c0, judul=Judul Buku, penulis=Penulis Buku, penerbit=Penerbit Buku, deskripsi=Deskripsi Buku, harga=20, stok=100, tanggal_terbit=2000-04-20, isbn=9780141199078, jumlah_halaman=300, foto_cover=https://img.freepik.com/free-psd/realistic-books-illustration_23-2150583561.jpg?w=740&t=st=1714023181~exp=1714023781~hmac=7cfc30e4018496977d01faef4fe928aabc8b2341986ef8303f56910954f5e076, kategori=Fiksi, buy_count=5)";
        assertEquals(expectedString, book1.toString());
    }

}