package com.example.book_bookku.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    private UUID id = UUID.randomUUID();
    private String judul;
    private String penulis;
    private String penerbit;
    private String deskripsi;
    private int harga;
    private int stok;
    private LocalDate tanggal_terbit;
    private String isbn;
    private int jumlah_halaman;
    private String foto_cover;
    private String kategori;
    private int buy_count = 0;

    public Book() {

    }

    public Book(Builder builder){
        this.id = builder.id;
        this.judul = builder.judul;
        this.penulis = builder.penulis;
        this.penerbit = builder.penerbit;
        this.deskripsi = builder.deskripsi;
        this.harga = builder.harga;
        this.stok = builder.stok;
        this.tanggal_terbit = builder.tanggal_terbit;
        this.isbn = builder.isbn;
        this.jumlah_halaman = builder.jumlah_halaman;
        this.foto_cover = builder.foto_cover;
        this.kategori = builder.kategori;
    }

    public static class Builder {
        private UUID id;
        private String judul;
        private String penulis;
        private String penerbit;
        private String deskripsi;
        private int harga;
        private int stok;
        private LocalDate tanggal_terbit;
        private String isbn;
        private int jumlah_halaman;
        private String foto_cover;
        private String kategori;

        public Builder() {
            this.id = UUID.randomUUID();
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setJudul(String judul) {
            this.judul = judul;
            return this;
        }

        public Builder setPenulis(String penulis) {
            this.penulis = penulis;
            return this;
        }

        public Builder setPenerbit(String penerbit) {
            this.penerbit = penerbit;
            return this;
        }

        public Builder setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
            return this;
        }

        public Builder setHarga(int harga) {
            this.harga = harga;
            return this;
        }

        public Builder setStok(int stok) {
            this.stok = stok;
            return this;
        }

        public Builder setTanggalTerbit(LocalDate tanggal_terbit) {
            this.tanggal_terbit = tanggal_terbit;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setJumlahHalaman(int jumlah_halaman) {
            this.jumlah_halaman = jumlah_halaman;
            return this;
        }

        public Builder setFotoCover(String foto_cover) {
            this.foto_cover = foto_cover;
            return this;
        }

        public Builder setKategori(String kategori) {
            this.kategori = kategori;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
