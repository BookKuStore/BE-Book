package com.example.book_bookku.controller;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.book_list_services.KeywordService;
import com.example.book_bookku.service.book_list_services.KeywordWithFilterService;
import com.example.book_bookku.service.book_list_services.SearchAllService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private KeywordService keywordService;

    @Mock
    private KeywordWithFilterService keywordWithFilterService;

    @Mock
    private SearchAllService searchAllService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBookListBy() {
        String keyword = "keyword";
        String filterBy = "filterBy";
        String sortBy = "sortBy";
        String sortDir = "sortDir";
        List<Book> expectedBookList = new ArrayList<>();
        when(searchAllService.handleRequest()).thenReturn(expectedBookList);

        List<Book> result = bookController.bookListBy(model, keyword, filterBy, sortBy, sortDir);

        assertEquals(expectedBookList, result);
        verify(searchAllService).setKeyword(keyword);
        verify(searchAllService).setFilterBy(filterBy);
        verify(searchAllService).setSortBy(sortBy);
        verify(searchAllService).setSortDir(sortDir);
        verify(searchAllService).setNextHandler(keywordService);
        verify(keywordService).setNextHandler(keywordWithFilterService);
        verify(model).addAttribute("bookList", expectedBookList);
        verify(model).addAttribute("keyword", keyword);
        verify(model).addAttribute("filter-by", filterBy);
        verify(model).addAttribute("sort-by", sortBy);
        verify(model).addAttribute("sort-dir", sortDir);
    }
}