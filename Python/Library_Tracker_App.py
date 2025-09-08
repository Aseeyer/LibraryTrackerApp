class Book:
    def __init__(self, title):
        self.title = title
        self.is_borrowed = False

library_books = [
    Book("Harry Potter and the Sorcerer's Stone"),
    Book("The Lord of the Rings"),
    Book("The Hobbit"),
    Book("Alice's Adventures in Wonderland"),
    Book("The Chronicles of Narnia"),
    Book("Charlotte's Web"),
    Book("Little Women"),
    Book("The Catcher in the Rye"),
    Book("Anne of Green Gables"),
    Book("Treasure Island")
]

def view_all_books():
    for index, book in enumerate(library_books):
        status = "Borrowed" if book.is_borrowed else "Available"
        print(f"{index + 1}. {book.title} - {status}")

def borrow_book(selected_book_index):
    if selected_book_index < 1 or selected_book_index > len(library_books):
        return
    book = library_books[selected_book_index - 1]
    if not book.is_borrowed:
        book.is_borrowed = True
    else:
        print("This book is already borrowed.")

def return_book(selected_book_index):
    if selected_book_index < 1 or selected_book_index > len(library_books):
        return
    book = library_books[selected_book_index - 1]
    if book.is_borrowed:
        book.is_borrowed = False
    else:
        print("This book is not currently borrowed.")

while True:
    print("\n1. View all books")
    print("2. Borrow a book")
    print("3. Return a book")
    print("4. Exit")
    user_choice = input("Choose an option: ")

    if user_choice == "1":
        view_all_books()
    elif user_choice == "2":
        view_all_books()
        book_selection = int(input("Enter the book number to borrow: "))
        borrow_book(book_selection)
    elif user_choice == "3":
        view_all_books()
        book_selection = int(input("Enter the book number to return: "))
        return_book(book_selection)
    elif user_choice == "4":
        print("Exiting Library Tracker.")
        break
    else:
        print("Invalid option.")
