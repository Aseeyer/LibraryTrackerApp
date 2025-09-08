import java.util.Scanner;

class Book {
    String title;
    boolean isBorrowed;

    Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }
}

public class LibraryTrackerApp {
    static Book[] libraryBooks = {
        new Book("Harry Potter and the Sorcerer's Stone"),
        new Book("The Lord of the Rings"),
        new Book("The Hobbit"),
        new Book("Alice's Adventures in Wonderland"),
        new Book("The Chronicles of Narnia"),
        new Book("Charlotte's Web"),
        new Book("Little Women"),
        new Book("The Catcher in the Rye"),
        new Book("Anne of Green Gables"),
        new Book("Treasure Island")
    };

    public static void viewAllBooks() {
        for (int index = 0; index < libraryBooks.length; index++) {
            String status = libraryBooks[index].isBorrowed ? "Borrowed" : "Available";
            System.out.println((index + 1) + ". " + libraryBooks[index].title + " - " + status);
        }
    }

    public static void borrowBook(int selectedBookIndex) {
        if (selectedBookIndex < 1 || selectedBookIndex > libraryBooks.length) return;
        Book selectedBook = libraryBooks[selectedBookIndex - 1];
        if (!selectedBook.isBorrowed) selectedBook.isBorrowed = true;
        else System.out.println("This book is already borrowed.");
    }

    public static void returnBook(int selectedBookIndex) {
        if (selectedBookIndex < 1 || selectedBookIndex > libraryBooks.length) return;
        Book selectedBook = libraryBooks[selectedBookIndex - 1];
        if (selectedBook.isBorrowed) selectedBook.isBorrowed = false;
        else System.out.println("This book is not currently borrowed.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            if (userChoice == 1) viewAllBooks();
            else if (userChoice == 2) {
                viewAllBooks();
                System.out.print("Enter the book number to borrow: ");
                int bookSelection = scanner.nextInt();
                scanner.nextLine();
                borrowBook(bookSelection);
            } else if (userChoice == 3) {
                viewAllBooks();
                System.out.print("Enter the book number to return: ");
                int bookSelection = scanner.nextInt();
                scanner.nextLine();
                returnBook(bookSelection);
            } else if (userChoice == 4) {
                System.out.println("Exiting Library Tracker.");
                break;
            } else System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
