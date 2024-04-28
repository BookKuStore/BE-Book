package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE CONCAT(b.judul, b.penulis) LIKE %?1%")
    public List<Book> search(String keyword);
}
