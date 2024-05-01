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
public class KeywordServiceTest {

//    @Autowired
//    SearchAllService searchAllService;
    @Autowired
    KeywordService keywordService;
    @MockBean
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
                "Penulis 3",
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

        keywordService.setNextHandler(keywordWithFilterService);
    }

    public List<Book> listAll(String keyword) {
        List<Book> filteredBook = new ArrayList<>();
        String lowerKey = keyword.toLowerCase();

        for (Book book : books) {
            String lowerName = book.getJudul().toLowerCase();
            String lowerAuthor = book.getPenulis().toLowerCase();

            if (lowerName.contains(lowerKey) || lowerAuthor.contains(lowerKey)) {
                filteredBook.add(book);
            }
        }
        return filteredBook;
    }

    @Test
    void testNextHandler() {
        assertEquals(keywordWithFilterService, keywordService.getNextHandler());
    }

    @Test
    void testKeywordIsValid() {
        keywordService.setKeyword("buku");
        String key = keywordService.getKeyword();

        List<Book> actualBooks = new ArrayList<>();
        actualBooks.add(books.get(0));
        actualBooks.add(books.get(1));

        List<Book> expectedBooks = listAll(key);

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void testKeywordIsNotValid() {

        keywordService.setKeyword("50");
        String key = keywordService.getKeyword();

        assertTrue(listAll(key).isEmpty());
    }
}
