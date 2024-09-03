

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementAppTest {
    private LibraryManagementApp app;

    @BeforeEach
    public void setUp() {
        app = new LibraryManagementApp();
    }

    @Test
    public void testAddBook() {
        app.addBook("Book Title", "Author Name", "123456789");
        assertNotNull(app.findBook("Book Title"));
    }

    @Test
    public void testCheckOutBook() {
        app.addBook("Another Book", "Author Name", "987654321");
        app.checkOutBook("Another Book");
        assertTrue(app.findBook("Another Book").isCheckedOut());
    }

    @Test
    public void testReturnBook() {
        app.addBook("Return Book", "Author Name", "111222333");
        app.checkOutBook("Return Book");
        app.returnBook("Return Book");
        assertFalse(app.findBook("Return Book").isCheckedOut());
    }

    @Test
    public void testViewAvailableBooks() {
        app.addBook("Available Book", "Author Name", "555666777");
        assertNotNull(app.findBook("Available Book"));
    }

    @Test
    public void testCheckOutBook_NotFound() {
        assertNull(app.findBook("Nonexistent Book"));
    }
}
