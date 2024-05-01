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
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringJUnitConfig
public class SearchAllServiceTest {

    @Autowired
    SearchAllService searchAllService;
    @MockBean
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

        searchAllService.setNextHandler(keywordService);
        keywordService.setNextHandler(keywordWithFilterService);

        when(bookRepository.findAll()).thenReturn(books);
    }

//    public List<Book> listAll(String keyword) {
//        List<Book> filteredBook = new ArrayList<>();
//        String lowerKey = keyword.toLowerCase();
//
//        for (Book book : books) {
//            String lowerName = book.getJudul().toLowerCase();
//            String lowerAuthor = book.getPenulis().toLowerCase();
//
//            if (lowerName.contains(lowerKey) || lowerAuthor.contains(lowerKey)) {
//                filteredBook.add(book);
//            }
//        }
//        return filteredBook;
//    }

    @Test
    void testNextHandler() {
        assertEquals(keywordService, searchAllService.getNextHandler());
    }

    @Test
    void testKeywordIsNull() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        searchAllService.setKeyword(null);
        assertEquals(books, bookRepository.findAll());
    }

    @Test
    void testKeywordIsEmpty() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        searchAllService.setKeyword("");
        assertEquals(books, bookRepository.findAll());
    }

//    @Test
//    void testKeywordIsValid() {
//        searchAllService.setKeyword("buku");
//        String key = searchAllService.getKeyword();
//
//        List<Book> actualBooks = new ArrayList<>();
//        actualBooks.add(books.get(0));
//        actualBooks.add(books.get(1));
//
//        List<Book> expectedBooks = listAll(key);
//
//        assertEquals(expectedBooks, actualBooks);
//    }
//
//    @Test
//    void testKeywordIsNotValid() {
//
//        searchAllService.setKeyword("50");
//        String key = searchAllService.getKeyword();
//
//        assertTrue(listAll(key).isEmpty());
//    }

//    @Test
//    void
//
//    @Test
//    void testCreateBook() {
//        Book book = books.get(1);
//        doReturn(book).when(bookRepository).save(book);
//
//        Book result = bookService.createBook(book);
//        verify(bookRepository, times(1)).save(book);
//        assertEquals(book.getId(), result.getId());
//    }
//
//    @Test
//    void testCreateBookIfAlreadyExists() {
//        Book book = books.get(1);
//        doReturn(book).when(bookRepository).findById(String.valueOf(book.getId()));
//
//        assertNull(bookService.createBook(book));
//        verify(bookRepository, times(0)).save(book);
//    }
//
//    @Test
//    void testUpdateDescription() {
//        Book book = books.get(1);
//        Book newBook = new Book(
//                book.getId(),
//                book.getJudul(),
//                book.getPenulis(),
//                book.getPenerbit(),
//                "Ini adalah buku terakhir",
//                book.getHarga(),
//                book.getStok(),
//                book.getTanggalTerbit(),
//                book.getISBN(),
//                book.getJumlahHalaman(),
//                book.getFotoCover(),
//                book.getKategori());
//
//        doReturn(book).when(bookRepository).findById(String.valueOf(book.getId()));
//        doReturn(newBook).when(bookRepository).save(any(Book.class));
//
//        Book result = bookService.updateDeskripsi(book.getId(), "Ini adalah buku terakhir");
//
//        assertEquals(book.getId(), result.getId());
//        assertEquals("Ini adalah buku terakhir", result.getDeskripsi());
//        verify(bookRepository, times(1)).save(any(Book.class));
//    }
//
////    @Test
////    void testUpdateStatusInvalidStatus() {
////        Book book = books.get(1);
////        doReturn(book).when(bookRepository).findById(book.getId());
////
////        assertThrows(IllegalArgumentException.class,
////                () -> bookService.updateDesskripsi(book.getId(), "HALO"));
////
////        verify(bookRepository, times(0)).save(any(Book.class));
////    }
//
//    @Test
//    void testUpdateStatusInvalidOrderId() {
//        doReturn(null).when(orderRepository).findById("zczc");
//
//        assertThrows(NoSuchElementException.class,
//                () -> orderService.updateStatus("zczc", OrderStatus.SUCCESS.getValue()));
//
//        verify(orderRepository, times(0)).save(any(Order.class));
//    }
//
//    @Test
//    void testFindByIdIfIdFound() {
//        Book book = books.get(1);
//        doReturn(book).when(bookRepository).findById(String.valueOf(book.getId()));
//
//        Book result = bookService.findById(book.getId());
//        assertEquals(book.getId(), result.getId());
//    }
//
//    @Test
//    void testFindByIdIfIdNotFound() {
//        doReturn(null).when(bookRepository).findById("zczc");
//        assertNull(bookService.findById("zczc"));
//    }
//
//    @Test
//    void testFindAllByAuthorIfAuthorCorrect() {
//        Book book = books.get(1);
//        doReturn(books).when(bookRepository).findAllByAuthor(book.getPenulis());
//
//        List<Book> results = bookService.findAllByAuthor(book.getPenulis());
//        for (Book result : results) {
//            assertEquals(book.getPenulis(), result.getPenulis());
//        }
//        assertEquals(2, results.size());
//    }
//
//    @Test
//    void testFindAllByAuthorIfAllLowercase() {
//        Book book = books.get(1);
//        doReturn(new ArrayList<Book>()).when(bookRepository)
//                .findAllByAuthor(book.getPenulis().toLowerCase());
//
//        List<Book> results = bookService.findAllByAuthor(
//                book.getPenulis().toLowerCase());
//        assertTrue(results.isEmpty());
//    }
}
