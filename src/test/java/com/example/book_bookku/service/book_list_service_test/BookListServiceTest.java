package com.example.book_bookku.service.book_list_service_test;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.book_list_services.BookListService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class BookListServiceTest {

    private BookListService bookListService;

    @BeforeEach
    public void setUp() {
        bookListService = new BookListService() {
            @Override
            public List<Book> handleRequest() {
                // Implementasi dummy hanya untuk keperluan pengujian
                return new ArrayList<>();
            }
        };
    }

    @Test
    public void testSetSortingAscending() {
        // Arrange
        bookListService.setSortDir("asc");
        bookListService.setSortBy("title");

        // Act
        bookListService.setSorting();

        // Assert
        assertEquals(Sort.Direction.ASC, bookListService.getSort().getOrderFor("title").getDirection());
    }

    @Test
    public void testSetSortingDescending() {
        // Arrange
        bookListService.setSortDir("desc");
        bookListService.setSortBy("title");

        // Act
        bookListService.setSorting();

        // Assert
        assertEquals(Sort.Direction.DESC, bookListService.getSort().getOrderFor("title").getDirection());
    }
}
