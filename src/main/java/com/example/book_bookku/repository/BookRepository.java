package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE LOWER(CONCAT(b.judul, b.penulis)) LIKE %:keyword%")
    List<Book> listAll(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b WHERE LOWER(b.judul) LIKE %:keyword%")
    List<Book> searchByName(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b WHERE LOWER(b.penulis) LIKE %:keyword%")
    List<Book> searchByAuthor(@Param("keyword") String keyword);

//    @Query("SELECT b FROM Book b WHERE LOWER(b.penulis) LIKE %:keyword% ORDER BY b.harga")
//    List<Book> searchByAuthor(@Param("keyword") String keyword);
}

