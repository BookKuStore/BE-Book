package com.example.book_bookku.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
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

    private Long id;
    private String judul;
    private String penulis;
    private String penerbit;
    private String deskripsi;
    private int harga;
    private int stok;
    private LocalDate tanggalTerbit;
    private String ISBN;
    private int jumlahHalaman;
    private String fotoCover;
    private String kategori;

    public Book() {

    }

    public Book(Long id, String judul, String penulis, String penerbit, String deskripsi, int harga, int stok, LocalDate tanggalTerbit, String ISBN, int jumlahHalaman, String fotoCover, String kategori) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.tanggalTerbit = tanggalTerbit;
        this.ISBN = ISBN;
        this.jumlahHalaman = jumlahHalaman;
        this.fotoCover = fotoCover;
        this.kategori = kategori;
    }

    public Book(String judul, String penulis, String penerbit, String deskripsi, int harga, int stok, LocalDate tanggalTerbit, String ISBN, int jumlahHalaman, String fotoCover, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.tanggalTerbit = tanggalTerbit;
        this.ISBN = ISBN;
        this.jumlahHalaman = jumlahHalaman;
        this.fotoCover = fotoCover;
        this.kategori = kategori;
    }
}
