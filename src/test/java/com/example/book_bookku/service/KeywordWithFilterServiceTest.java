package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
public class KeywordWithFilterServiceTest {

    @Autowired
    KeywordWithFilterService keywordWithFilterService;
    @MockBean
    BookRepository bookRepository;
    List<Book> books;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        Book book1 = new Book(
                1,
                "Buku 1",
                "Penulis 1",
                "Penerbit 1",
                "Ini adalah buku pertama",
                100000,
                10,
                LocalDate.of(2001, Month.APRIL, 3),
                "1234567890123",
                100,
                "https://www.google.com/",
                "Fiksi");

        Book book2 = new Book(2,
                "Buku 2",
                "Penulis 2",
                "Penerbit 2",
                "Ini adalah buku kedua",
                200000,
                20,
                LocalDate.of(2002, Month.APRIL, 3),
                "1234567890234",
                200,
                "https://www.youtube.com/",
                "Aksi");

        Book book3 = new Book(3,
                "book 3",
                "Jono 3",
                "Penerbit 3",
                "Ini adalah buku ketiga",
                300000,
                30,
                LocalDate.of(2003, Month.APRIL, 3),
                "1234567890345",
                300,
                "https://www.youtube.com/",
                "Petualangan");

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    public List<Book> listAllWithFilter(String keyword, String filterBy) {
        List<Book> filteredBook = new ArrayList<>();
        String lowerKey = keyword.toLowerCase();

        for (Book book : books) {
            String lowerTitle = book.getJudul().toLowerCase();
            String lowerAuthor = book.getPenulis().toLowerCase();

            if (filterBy.equalsIgnoreCase("judul")) {
               if (lowerTitle.contains(lowerKey)) {
                   filteredBook.add(book);
               }
            } else if (filterBy.equalsIgnoreCase("penulis")||
                    filterBy.equalsIgnoreCase("pengarang")) {
                if (lowerAuthor.contains(lowerKey)) {
                    filteredBook.add(book);
                }
            }
        }
        return filteredBook;
    }

    @Test
    void testNextHandler() {
        assertNull(keywordWithFilterService.getNextHandler());
    }

    @Test
    void testFilterIsNull() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        keywordWithFilterService.setFilterBy(null);
        assertNull(keywordWithFilterService.handleRequest());
    }

    @Test
    void testFilterIsEmpty() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        keywordWithFilterService.setKeyword("");
        assertNull(keywordWithFilterService.handleRequest());
    }

    @Test
    void testFilterIsValidAndKeywordIsValid() {
        keywordWithFilterService.setKeyword("pen");
        keywordWithFilterService.setFilterBy("pengarang");

        String key = keywordWithFilterService.getKeyword();
        String filter = keywordWithFilterService.getFilterBy();

        List<Book> actualBooks = new ArrayList<>();
        actualBooks.add(books.get(0));
        actualBooks.add(books.get(1));

        List<Book> expectedBooks = listAllWithFilter(key, filter);

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void testFilterIsValidButKeywordIsNot() {
        keywordWithFilterService.setKeyword("50");
        keywordWithFilterService.setFilterBy("penulis");

        String key = keywordWithFilterService.getKeyword();
        String filter = keywordWithFilterService.getFilterBy();

        assertTrue(listAllWithFilter(key, filter).isEmpty());
    }

    @Test
    void testFilterIsNotValid() {
        keywordWithFilterService.setKeyword("penulis");
        keywordWithFilterService.setFilterBy("Indonesia");

        String key = keywordWithFilterService.getKeyword();
        String filter = keywordWithFilterService.getFilterBy();

        assertTrue(listAllWithFilter(key, filter).isEmpty());
    }
}
