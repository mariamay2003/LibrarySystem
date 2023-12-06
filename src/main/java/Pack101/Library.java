/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Library {

    ArrayList<Loan> loans;
    ArrayList<Book> books;
    ArrayList<Student> students;

    public Library() {
        loans = new ArrayList<>();
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                students.remove(i);
            }
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBookByNo(int number) {
        Book b = new Book();
        boolean p = false;
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getNo() == number) {
                b = books.get(i);
                p = true;
            }
        }
        if (p) {
            return b;
        } else {
            return null;
        }
    }

    public Book searchBookByTitle(String title) {
        Book b2 = new Book();
        boolean p2 = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                b2 = books.get(i);
                p2 = true;
            }
        }
        if (p2) {
            return b2;
        } else {
            return null;
        }
    }

    public Book searchBookByAuthorName(String name) {
        Book b3 = new Book();
        boolean p3 = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(name)) {
                b3 = books.get(i);
                p3 = true;
            }
        }
        if (p3) {
            return b3;
        } else {
            return null;
        }
    }

    public void AddToLoan(Student student, Book book, BirthDate date) {
        Loan loan = new Loan(book, student, date);
        for (int i = 0; i < students.size(); i++) {
            if (student.equals(students.get(i))) {
                if (student.countDays() < 5 && student.numberOfBooksLoaned() < 3) {
                    loans.add(loan);
                    loan.incrementLoans();
                }
            }
        }

    }

    public boolean removeFromLoan(String bookTitle) {
        Book book = searchBookByTitle(bookTitle);
        boolean bool = false;
        if (book != null) {
            for (int i = 0; i < loans.size(); i++) {
                if (loans.get(i).getBook().getTitle().equalsIgnoreCase(bookTitle)) {
                    loans.remove(i);
                    loans.get(i).decrementLoans();
                    bool = true;
                    break;

                }
            }
        }
        return bool;
    }

    public Student searchStudentById(int id) {
        boolean p4 = false;
        Student student = new Student();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                student = students.get(i);
                p4 = true;
                break;
            }
        }
        if (p4) {
            return student;
        } else {
            return null;
        }
    }

}
