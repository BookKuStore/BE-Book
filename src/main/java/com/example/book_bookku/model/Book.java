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
    private UUID id = UUID.randomUUID();;
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

    public Book() {

    }

    public Book(Builder builder){

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
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder setId(UUID id) {
            return null;
        }

        public Builder setJudul(String judul) {
            return null;
        }

        public Builder setPenulis(String penulis) {
            return null;
        }

        public Builder setPenerbit(String penerbit) {
            return null;
        }

        public Builder setDeskripsi(String deskripsi) {
            return null;
        }

        public Builder setHarga(int harga) {
            return null;
        }

        public Builder setStok(int stok) {
            return null;
        }

        public Builder setTanggalTerbit(LocalDate tanggal_terbit) {
            return null;
        }

        public Builder setIsbn(String isbn) {
            return null;
        }

        public Builder setJumlahHalaman(int jumlah_halaman) {
            return null;
        }

        public Builder setFotoCover(String foto_cover) {
            return null;
        }

        public Builder setKategori(String kategori) {
            return null;
        }

        public Book build() {
            return null;
        }
    }
}
