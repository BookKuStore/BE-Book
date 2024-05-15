package com.example.book_bookku.service.book_list_services;

import com.example.book_bookku.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KeywordService extends BookListService {
    @Override
    public List<Book> handleRequest() {
        if (!Objects.equals(this.filterBy, "")) {
            nextHandler.setKeyword(this.keyword);
            nextHandler.setFilterBy(this.filterBy);
            nextHandler.setSortBy(this.sortBy);
            nextHandler.setSortDir(this.sortDir);

            return nextHandler.handleRequest();
        }
        setSorting();

        return bookRepository.listAll(this.keyword, sort);
    }
}
