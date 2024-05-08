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
            setSorting();
            if (Objects.equals(filterBy, "judul")) {
                return bookRepository.searchByTitle(keyword, sort);
            } else if (Objects.equals(filterBy, "penulis") || Objects.equals(filterBy, "pengarang")) {
                return bookRepository.searchByAuthor(keyword, sort);
            }
        }
        return null;
    }
}