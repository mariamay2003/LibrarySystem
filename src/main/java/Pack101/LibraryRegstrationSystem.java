/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Pack101;

import Pack102.MainGUI;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class LibraryRegstrationSystem {

    public static void main(String[] args) {
        //Pack102.MainGUI.main(args);
        // Create a scanner object for user input
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        // Create a registration system object
        Library library = new Library();
        library.setBooks(DataManager.loadBooksFromFile());
        int choice;
        while (true) {
            // Display a menu for the user
            System.out.println("Welcome to the Library Registration System!");
            System.out.println("1. Add a book");
            System.out.println("2. Loan a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add a student");
            System.out.println("5. Search a book by title");
            System.out.println("6. Search a book by author");
            System.out.println("7. Search a book by number");
            System.out.println("8. Exit");

            System.out.println("Please select an option from the menu:");
            choice = sc1.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the book details:");
                    System.out.println("Release Date (day ,month,year) : ");
                    BirthDate date = new BirthDate(sc1.nextInt(), sc1.nextInt(), sc1.nextInt());
                    System.out.println("Author (id and name) : ");
                    Author author = new Author(sc1.nextInt(), sc2.nextLine());
                    System.out.println("Title: ");
                    String title = sc3.nextLine();
                    System.out.println("No: ");
                    int no = sc1.nextInt();
                    System.out.println("Genre: ");
                    String genre = sc4.nextLine();
                    System.out.println("Version: ");
                    int version = sc1.nextInt();
                    System.out.println("Choose the book type:");
                    System.out.println("1. Magazine");
                    System.out.println("2. Journal");
                    System.out.println("3. Book");

                    int type = sc1.nextInt();
                    sc2.nextLine();
                    // Declare a variable for the book object
                    Book book = null;
                    // Switch on the user's choice
                    switch (type) {
                        // Case 1: Magazine
                        case 1:
                            // Prompt the user to enter the magazine details
                            System.out.println("Enter the magazine details:");
                            System.out.print("Issue No: ");
                            int issueNo = sc1.nextInt();
                            sc1.nextLine();
                            // Create a magazine object
                            book = new Magazine(issueNo, date, author, title, no, genre, version);
                            break;
                        // Case 2: Journal
                        case 2:
                            // Prompt the user to enter the journal details
                            System.out.println("Enter the journal details:");
                            System.out.print("Conference Name: ");
                            String conferenceName = sc2.nextLine();
                            System.out.print("Conference No: ");
                            int conferenceNo = sc1.nextInt();
                            sc2.nextLine();
                            // Create a journal object
                            book = new Journal(conferenceName, conferenceNo, date, author, title, no, genre, version);
                            break;
                        // Case 3: Book
                        case 3:
                            // Create a book object
                            book = new Book(date, author, title, no, genre, version);
                            break;
                        // Default: Invalid choice
                        default:
                            // Display an error message
                            System.out.println("Invalid choice!");
                            break;
                    }
                    // Check if the book object is not null
                    if (book != null) {
                        // Add the book to the system
                        library.addBook(book);

                        //MainGUI.library.getBooks().add(book);
                        DataManager.saveBooksToFile(library.getBooks());
                        // Display a success message
                        System.out.println("Book added successfully!");
                    }
                    break;

                case 2:
                    System.out.println("Enter the student id and the book no:");
                    System.out.print("Student id: ");
                    int studentId = sc1.nextInt();
                    sc1.nextLine();
                    System.out.print("Book no: ");
                    int bookNo = sc2.nextInt();
                    sc2.nextLine();
                    /*System.out.println("enter current date :");
                    BirthDate date2 = new BirthDate(sc1.nextInt(), sc1.nextInt(), sc1.nextInt());*/
                    LocalDate currentDate = LocalDate.now();
                    // Create a BirthDate object using the current date
                    BirthDate date2 = new BirthDate(
                            currentDate.getDayOfMonth(),
                            currentDate.getMonthValue(),
                            currentDate.getYear()
                    );
                    // Declare variables for the student and the book objects
                    Student student = null;
                    Book book1 = null;
                    // Loop through the students list
                    for (Student s : library.getStudents()) {
                        // Check if the student id matches
                        if (s.getId() == studentId) {
                            // Assign the student object
                            student = s;
                            // Break the loop
                            break;
                        }
                    }
                    // Loop through the books list
                    for (Book b : library.getBooks()) {
                        // Check if the book no matches
                        if (b.getNo() == bookNo) {
                            // Assign the book object
                            book1 = b;
                            // Break the loop
                            break;
                        }
                    }
                    // Check if the student and the book objects are not null
                    if (student != null && book1 != null) {
                        library.AddToLoan(student, book1, date2);
                    }
                    break;
                case 3:
                    System.out.println("Enter book name :");
                    String title2 = sc2.nextLine();
                    if (library.removeFromLoan(title2)) {
                        System.out.println("book returned successfully !!");
                    } else {
                        System.out.println("book not exist !");
                    }
                    break;
                case 4:
                    System.out.println("Enter the student details:");
                    System.out.print("Id: ");
                    int id = sc1.nextInt();
                    sc1.nextLine();
                    System.out.print("Name: ");
                    String name = sc2.nextLine();
                    System.out.print("Address: ");
                    String address = sc2.nextLine();
                    System.out.print("Birth Date (day,month,year) : ");
                    BirthDate date3 = new BirthDate(sc1.nextInt(), sc1.nextInt(), sc1.nextInt());
                    System.out.print("Major: ");
                    String major = sc3.nextLine();
                    // Create a student object
                    Student student2 = new Student(major, id, name, address, date3);
                    // Add the student to the system
                    library.addStudent(student2);
                    // Display a success message
                    System.out.println("Student added successfully!");
                    break;

                // Case 5: Search a book by title
                case 5:
                    // Prompt the user to enter the book title
                    System.out.print("Enter the book title: ");
                    String title3 = sc1.nextLine();
                    sc1.nextLine();

                    // Call the method to search for the book by title
                    Book foundBook = library.searchBookByTitle(title3);

                    // Check if the book was found
                    if (foundBook != null) {
                        // Display the book information
                        System.out.println("Book found!");
                        System.out.println(foundBook.getInfo());
                    } else // Display a message if the book was not found
                    {
                        System.out.println("Book not found!");
                    }

                    break;

                case 6:
                    // Prompt the user to enter the book author
                    System.out.print("Enter the book author: ");
                    String searchAuthor = sc2.nextLine();

                    // Call the method to search for the book by author
                    Book foundBookByAuthor = library.searchBookByAuthorName(searchAuthor);

                    // Check if the book was found
                    if (foundBookByAuthor != null) {
                        // Display the book information
                        System.out.println("Book found!");
                        System.out.println(foundBookByAuthor.getInfo());
                    } else {
                        // Display a message if the book was not found
                        System.out.println("Book not found!");
                    }
                    break;

                case 7:
                    System.out.print("Enter the book number : ");
                    int searchNumber = sc2.nextInt();

                    // Call the method to search for the book by author
                    Book foundBookByNumber = library.searchBookByNo(searchNumber);

                    // Check if the book was found
                    if (foundBookByNumber != null) {
                        // Display the book information
                        System.out.println("Book found!");
                        System.out.println(foundBookByNumber.getInfo());
                    } else {
                        // Display a message if the book was not found
                        System.out.println("Book not found!");
                    }
                    break;

                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice !");
            }
        }
    }
}
