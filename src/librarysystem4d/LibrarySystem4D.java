package librarysystem4d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibrarySystem4D {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<book> bookList = new ArrayList<>();
    private static ArrayList<borrower> borrowerList = new ArrayList<>();
    private static ArrayList<book> borrowedBooks = new ArrayList<>();
    private static ArrayList<borrower> borrowers = new ArrayList<>();

    // Make a borrowed books file
    public static void main(String[] args) {
        bookList = fileHandling.readBookFile();
        borrowerList = fileHandling.readBorrowerFile();
        mainMenu();

    }

    public static void mainMenu() {
        System.out.println("Welcome to my library");
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1 - Add a new book");
            System.out.println("2 - View all books");
            System.out.println("3 - Edit a book");
            System.out.println("4 - Delete a book");
            System.out.println("5 - Add a new borrower");
            System.out.println("6 - Edit a borrower");
            System.out.println("7 - Delete a borrower");
            System.out.println("8 - View all borrowers");
            System.out.println("9 - Borrow a book");
            System.out.println("10 - View all books being borrowed");
            System.out.println("0 - Exit");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    addBorrower();
                    break;
                case 6:
                    editBorrower();
                    break;
                case 7:
                    deleteBorrower();
                    break;
                case 8:
                    viewAllBorrowers();
                    break;
                case 9:
                    borrowBook();
                    break;
                case 10:
                    viewAllBorrowedBooks();
                    break;
                case 0:
                    fileHandling.writeBookFile(bookList);
                    fileHandling.writeBorrowerFile(borrowerList);
                    System.exit(0);
                    break;
            }

        }
    }

    public static void addBook() {
        //String name, String ISBN, double price, String author, String genre

        System.out.println("Please type in a name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Please type in an ISBN");
        String ISBN = input.nextLine();
        System.out.println("Please type in a price");
        double price = input.nextDouble();
        System.out.println("Please type in an author");
        input.nextLine();
        String author = input.nextLine();
        System.out.println("Please type in a genre");
        String genre = input.nextLine();

        book myBook = new book(name, ISBN, price, author, genre);
        bookList.add(myBook);

    }

    public static void viewAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Sorry, there are no books in the library right now.");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i).toString());
            }
        }
    }

    public static void editBook() {

        int index = getBookIndex();

        if (index == -1) {
            System.out.println("Sorry, this is not a valid book.");
        } else {
            System.out.println("What would you like to edit?");
            System.out.println("1 - name");
            System.out.println("2 - ISBN");
            System.out.println("3 - price");
            System.out.println("4 - author");
            System.out.println("5 - genre");
            System.out.println("6 - never mind");
            input.nextLine();
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please type in the new name");
                    String newName = input.nextLine();
                    bookList.get(index).setName(newName);
                    break;
                case 2:
                    System.out.println("Please type in the new ISBN");
                    String newISBN = input.nextLine();
                    bookList.get(index).setISBN(newISBN);
                    break;
                case 3:
                    System.out.println("Please type in the new price");
                    double newPrice = input.nextDouble();
                    bookList.get(index).setPrice(newPrice);
                    break;
                case 4:
                    System.out.println("Please type in the new author");
                    String newAuthor = input.nextLine();
                    bookList.get(index).setAuthor(newAuthor);
                    break;
                case 5:
                    System.out.println("Please type in the new genre");
                    String newGenre = input.nextLine();
                    bookList.get(index).setGenre(newGenre);
                    break;
                case 6:
                    break;
            }
            System.out.println("Book successfully changed to " + bookList.get(index).toString());
        }
    }

    public static void deleteBook() {

        int index = getBookIndex();

        if (index == -1) {
            System.out.println("Sorry, this is not a valid book.");
        } else {
            bookList.remove(index);
            System.out.println("Book successfully removed.");
        }

    }

    public static int getBookIndex() {
        System.out.println("Please type in the book name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Please type in the ISBN");
        String ISBN = input.nextLine();

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name) && bookList.get(i).getISBN().equals(ISBN)) {
                return i;
            }
        }
        return -1;
    }

    public static void addBorrower() {
        System.out.println("Please type in the borrower's name");
        input.nextLine();
        String borrowerName = input.nextLine();
        System.out.println("Please type in the borrower's email address");
        String email = input.nextLine();

        borrower newBorrower = new borrower(borrowerName, email);
        borrowerList.add(newBorrower);
    }

    public static int getBorrowerIndex() {
        System.out.println("Please type in the borrower's name");
        input.nextLine();
        String borrowerName = input.nextLine();
        System.out.println("Please type in the email the borrower uses");
        String email = input.nextLine();

        for (int i = 0; i < borrowerList.size(); i++) {
            if (borrowerList.get(i).getBorrowerName().equals(borrowerName) && borrowerList.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public static void editBorrower() {
        int index = getBorrowerIndex();

        if (index == -1) {
            System.out.println("Sorry this is not a valid borrower");
        } else {
            System.out.println("What would you like to edit?");
            System.out.println("1 - Borrower name");
            System.out.println("2 - Email");
            System.out.println("3 - Never mind");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please enter the borrower's new name");
                    input.nextLine();
                    String newBorrowerName = input.nextLine();
                    borrowerList.get(index).setBorrowerName(newBorrowerName);
                    break;
                case 2:
                    System.out.println("Please enter the borrower's new email");
                    input.nextLine();
                    String newEmail = input.nextLine();
                    borrowerList.get(index).setEmail(newEmail);
                    break;
                case 3:
                    break;
            }
            System.out.println("Sucessfully chnaged to " + borrowerList.get(index).toString());
        }
    }

    public static void deleteBorrower() {
        int index = getBorrowerIndex();

        if (index == -1) {
            System.out.println("Sorry, this is not a valid borrower.");
        } else {
            borrowerList.remove(index);
            System.out.println("Borrower successfully removed.");
        }
    }

    public static void viewAllBorrowers() {
        if (borrowerList.isEmpty()) {
            System.out.println("Sorry, there currently isn't any borrowers");
        } else {
            for (int i = 0; i < borrowerList.size(); i++) {
                System.out.println(borrowerList.get(i).toString());
            }
        }
    }

    public static void borrowBook() {
        int index = getBorrowerIndex();

        if (index == -1) {
            System.out.println("Sorry this borrower doesn't exist");
        } else {
            int bookIndex = getBookIndex();
            if (bookIndex == -1) {
                System.out.println("Sorry this book doesn't exist");
            } else {
                String name = bookList.get(bookIndex).getName();
                String ISBN = bookList.get(bookIndex).getISBN();
                for (int i = 0; i < borrowedBooks.size(); i++) {
                    if (borrowedBooks.get(i).getName().equals(name) && borrowedBooks.get(i).getISBN().equals(ISBN)) {
                        System.out.println("Sorry, this book is already being borrowed");
                        break;
                    }
                }
                    double price = bookList.get(bookIndex).getPrice();
                    String author = bookList.get(bookIndex).getAuthor();
                    String genre = bookList.get(bookIndex).getGenre();
                    book newBook = new book(name, ISBN, price, author, genre);
                    borrowedBooks.add(newBook);
                    String borrowerName = borrowerList.get(index).getBorrowerName();
                    String email = borrowerList.get(index).getEmail();
                    borrower newBorrower = new borrower(borrowerName, email);
                    borrowers.add(newBorrower);
                    System.out.println(borrowerName+" is now borrowing "+name);
                }
            }
        }
    
    public static void viewAllBorrowedBooks(){
        if (borrowedBooks.isEmpty()) {
            System.out.println("There are no books being borrowed right now.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println(borrowedBooks.get(i).toString());
            }
        }
    }

    }
