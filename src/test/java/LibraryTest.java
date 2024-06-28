import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Title1", "Author1", 2021, "ISBN1");
        library.addBook(book);
        List<Book> books = library.getAllBooks();
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Title1", "Author1", 2021, "ISBN1");
        library.addBook(book);
        library.removeBook("ISBN1");
        List<Book> books = library.getAllBooks();
        assertTrue(books.isEmpty());
    }

    @Test
    public void testSearchByTitle() {
        Book book1 = new Book("Title1", "Author1", 2021, "ISBN1");
        Book book2 = new Book("Title2", "Author2", 2022, "ISBN2");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> results = library.searchByTitle("Title1");
        assertEquals(1, results.size());
        assertEquals(book1, results.get(0));
    }

    @Test
    public void testSearchByAuthor() {
        Book book1 = new Book("Title1", "Author1", 2021, "ISBN1");
        Book book2 = new Book("Title2", "Author2", 2022, "ISBN2");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> results = library.searchByAuthor("Author2");
        assertEquals(1, results.size());
        assertEquals(book2, results.get(0));
    }

    @Test
    public void testSearchByYear() {
        Book book1 = new Book("Title1", "Author1", 2021, "ISBN1");
        Book book2 = new Book("Title2", "Author2", 2022, "ISBN2");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> results = library.searchByYear(2021);
        assertEquals(1, results.size());
        assertEquals(book1, results.get(0));
    }
}
