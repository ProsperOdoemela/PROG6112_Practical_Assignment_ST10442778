
//W3schools.com (no date) W3Schools Online Web Tutorials. Available at: https://www.w3schools.com/ (Accessed: 03 September 2024). 
//Learn to code - for free (no date) Codecademy. Available at: https://www.codecademy.com/ (Accessed: 03 September 2024). 
//Build new skills. advance your career. (no date) edX. Available at: https://www.edx.org/ (Accessed: 03 September 2024). 
//FreeCodeCamp.org (no date) freecodecamp.org. Available at: https://www.freecodecamp.org/ (Accessed: 03 September 2024). 

package librarymanagementappq2;

/**
 *
 * @author prosp
 */
import java.util.ArrayList;
import java.util.Scanner;
// Main application class
public class LibraryManagementAppQ2 {
    private static ArrayList<Book> library = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    checkOutBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    viewAvailableBooks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the library system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to show the menu
    public static void showMenu() {
        System.out.println("\n==== Library Management System ====");
        System.out.println("1. Add a New Book");
        System.out.println("2. Check Out a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. View Available Books");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Method to add a new book to the library
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        Book newBook = new Book(title, author, isbn);
        library.add(newBook);

        System.out.println("Book successfully added!");
    }

    // Method to check out a book
    public static void checkOutBook() {
        System.out.print("Enter the book title to check out: ");
        String title = scanner.nextLine();

        Book foundBook = findBook(title);
        if (foundBook != null) {
            if (!foundBook.isCheckedOut()) {
                foundBook.setCheckedOut(true);
                System.out.println("You have successfully checked out the book: " + foundBook.getTitle());
            } else {
                System.out.println("Sorry, the book is already checked out.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to return a book
    public static void returnBook() {
        System.out.print("Enter the book title to return: ");
        String title = scanner.nextLine();

        Book foundBook = findBook(title);
        if (foundBook != null) {
            if (foundBook.isCheckedOut()) {
                foundBook.setCheckedOut(false);
                System.out.println("You have successfully returned the book: " + foundBook.getTitle());
            } else {
                System.out.println("This book wasn't checked out.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to view all available books
    public static void viewAvailableBooks() {
        System.out.println("\n==== Available Books ====");
        for (Book book : library) {
            if (!book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }

    // Helper method to find a book by title
    public static Book findBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}