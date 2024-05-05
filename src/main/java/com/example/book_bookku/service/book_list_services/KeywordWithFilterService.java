package com.example.book_bookku.service.book_list_services;

import com.example.book_bookku.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KeywordWithFilterService extends BookListService {
    @Override
    public List<Book> handleRequest() {
        if (filterBy != null) {
            if (Objects.equals(filterBy, "judul")) {
                return bookRepository.searchByTitle(keyword);
            } else if (Objects.equals(filterBy, "penulis") || Objects.equals(filterBy, "pengarang")) {
//                System.out.println("halo");
                return bookRepository.searchByAuthor(keyword);
            }
        }
        return null;
    }
}