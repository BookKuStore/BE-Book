package com.example.book_bookku.service.book_list_services;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BookListService {

    @Autowired
    protected BookRepository bookRepository;

    @Setter@Getter
    protected BookListService nextHandler;
    @Setter@Getter
    protected String keyword;
    @Setter@Getter
    protected String filterBy;
    @Setter@Getter
    protected String sortBy;
    @Setter@Getter
    protected String sortDir;
    @Setter@Getter
    protected Sort sort;

    public abstract List<Book> handleRequest();

    public void setSorting() {
        if (this.sortDir.equals("desc")) {
            sort = Sort.by(this.sortBy).descending();
        } else {
            sort = Sort.by(this.sortBy).ascending();
        }
    }
}