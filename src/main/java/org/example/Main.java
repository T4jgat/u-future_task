package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search books");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    displayAllBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, year, isbn);
        library.addBook(book);
        System.out.println("Book added.");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
        System.out.println("Book removed.");
    }

    private static void searchBooks() {
        System.out.println("1. Search by title");
        System.out.println("2. Search by author");
        System.out.println("3. Search by year");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Book> results = null;
        switch (choice) {
            case 1:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                results = library.searchByTitle(title);
                break;
            case 2:
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                results = library.searchByAuthor(author);
                break;
            case 3:
                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                scanner.nextLine(); // consume newline
                results = library.searchByYear(year);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        if (results != null && !results.isEmpty()) {
            results.forEach(System.out::println);
        } else {
            System.out.println("No books found.");
        }
    }

    private static void displayAllBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

}