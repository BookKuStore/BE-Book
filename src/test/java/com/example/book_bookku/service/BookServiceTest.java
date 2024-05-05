//package com.example.book_bookku.service;
//
//import com.example.book_bookku.model.Book;
//import com.example.book_bookku.repository.BookRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.times;
//import java.util.NoSuchElementException;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class BookServiceTest {
//    @InjectMocks
//    BookService bookService;
//    @Mock
//    BookRepository bookRepository;
//    List<Book> books;
//
//    @BeforeEach
//    void setUp() {
//        books = new ArrayList<>();
//        Book book1 = new Book(
//                1L,
//                "Buku 1",
//                "Penulis 1",
//                "Penerbit 1",
//                "Ini adalah buku pertama",
//                100000,
//                10,
//                LocalDate.of(2001, Month.APRIL, 3),
//                "1234567890123",
//                100,
//                "https://www.google.com/",
//                "Fiksi");
//
//        Book book2 = new Book(2L,
//                "Buku 2",
//                "Penulis 2",
//                "Penerbit 2",
//                "Ini adalah buku kedua",
//                200000,
//                20,
//                LocalDate.of(2002, Month.APRIL, 3),
//                "1234567890234",
//                200,
//                "https://www.youtube.com/",
//                "Aksi");
//
//        books.add(book1);
//        books.add(book2);
//    }
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
//}
