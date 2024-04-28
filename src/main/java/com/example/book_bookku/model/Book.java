package com.example.book_bookku.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "buku")
@Getter @Setter
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Integer id;
    private String judul;
    private String penulis;
    private String penerbit;
    private String deskripsi;
    private int harga;
    private int stok;
    private LocalDate tanggalterbit;
    private String isbn;
    private int jumlahhalaman;
    private String fotocover;
    private String kategori;

    public Book() {

    }

    public Book(Integer id, String judul, String penulis, String penerbit, String deskripsi, int harga, int stok, LocalDate tanggalterbit, String isbn, int jumlahhalaman, String fotocover, String kategori) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.tanggalterbit = tanggalterbit;
        this.isbn = isbn;
        this.jumlahhalaman = jumlahhalaman;
        this.fotocover = fotocover;
        this.kategori = kategori;
    }

    public Book(String judul, String penulis, String penerbit, String deskripsi, int harga, int stok, LocalDate tanggalterbit, String isbn, int jumlahhalaman, String fotocover, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.tanggalterbit = tanggalterbit;
        this.isbn = isbn;
        this.jumlahhalaman = jumlahhalaman;
        this.fotocover = fotocover;
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Buku [id=" + id + ", judul=" + judul + ", penulis=" + penulis + "]";
    }
}
