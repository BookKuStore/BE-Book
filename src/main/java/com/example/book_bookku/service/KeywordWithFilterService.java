package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KeywordWithFilterService extends BookService {
//    @Override
//    public List<Book> handleRequest(String keyword, String filterBy) {
//        if (filterBy != null) {
//            if (Objects.equals(filterBy, "judul")) {
//                return bookRepository.searchByName(keyword);
//            } else if (Objects.equals(filterBy, "penulis") || Objects.equals(filterBy, "pengarang")) {
//                return bookRepository.searchByAuthor(keyword);
//            }
//        }
//        return null;
//    }
    @Override
    public List<Book> handleRequest() {
        if (filterBy != null) {
            if (Objects.equals(filterBy, "judul")) {
                return bookRepository.searchByName(keyword);
            } else if (Objects.equals(filterBy, "penulis") || Objects.equals(filterBy, "pengarang")) {
//                System.out.println("halo");
                return bookRepository.searchByAuthor(keyword);
            }
        }
        return null;
    }
}
