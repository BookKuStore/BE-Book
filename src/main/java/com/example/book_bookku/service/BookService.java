package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(String keyword, String filterBy){

        if (keyword != null) {
            System.out.println(filterBy);
            return getBooksWithKeyword(keyword.toLowerCase(), filterBy);
        }
        return bookRepository.findAll();
    }

    public List<Book> getBooksWithKeyword(String keyword, String filterBy) {
        if (filterBy != null) {
            return getBooksWithFilter(keyword, filterBy.toLowerCase());
        }
        return bookRepository.searchAll(keyword);
    }

    public List<Book> getBooksWithFilter(String keyword, String filterBy) {
        if (Objects.equals(filterBy, "judul")) {
            return bookRepository.searchByName(keyword);
        } else if (Objects.equals(filterBy, "penulis")) {
            return bookRepository.searchByAuthor(keyword);
        }

        return bookRepository.findAll();
    }
}
