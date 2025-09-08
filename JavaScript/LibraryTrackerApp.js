const prompt = require('prompt-sync')({ sigint: true });

class Book {
    constructor(title) {
        this.title = title;
        this.isBorrowed = false;
    }
}

const libraryBooks = [
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
];

function viewAllBooks() {
    libraryBooks.forEach((book, index) => {
        const status = book.isBorrowed ? "Borrowed" : "Available";
        console.log(`${index + 1}. ${book.title} - ${status}`);
    });
}

function borrowBook(selectedBookIndex) {
    if (selectedBookIndex < 1 || selectedBookIndex > libraryBooks.length) return;
    const selectedBook = libraryBooks[selectedBookIndex - 1];
    if (!selectedBook.isBorrowed) selectedBook.isBorrowed = true;
    else console.log("This book is already borrowed.");
}

function returnBook(selectedBookIndex) {
    if (selectedBookIndex < 1 || selectedBookIndex > libraryBooks.length) return;
    const selectedBook = libraryBooks[selectedBookIndex - 1];
    if (selectedBook.isBorrowed) selectedBook.isBorrowed = false;
    else console.log("This book is not currently borrowed.");
}

while (true) {
    console.log("\n1. View all books");
    console.log("2. Borrow a book");
    console.log("3. Return a book");
    console.log("4. Exit");
    const userChoice = parseInt(prompt("Choose an option: "));

    if (userChoice === 1) viewAllBooks();
    else if (userChoice === 2) {
        viewAllBooks();
        const bookSelection = parseInt(prompt("Enter the book number to borrow: "));
        borrowBook(bookSelection);
    } else if (userChoice === 3) {
        viewAllBooks();
        const bookSelection = parseInt(prompt("Enter the book number to return: "));
        returnBook(bookSelection);
    } else if (userChoice === 4) {
        console.log("Exiting Library Tracker.");
        break;
    } else console.log("Invalid option.");
}
