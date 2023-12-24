/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.util.Objects;

/**
 *
 * @author maria
 */
public class Loan {

    private Book book;
    private Student student;
    private BirthDate date;
    private int incLoans;
    private int decLoans;

    public Loan() {
    }

    public Loan(Book book, Student student, BirthDate dueDate) {
        this.book = book;
        this.student = student;
        this.date = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BirthDate getDate() {
        return date;
    }

    public void setDate(BirthDate date) {
        this.date = date;
    }

    public int incrementLoans() {
        incLoans++;
        return incLoans;
    }

    public int decrementLoans() {
        decLoans++;
        return decLoans;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.book);
        hash = 59 * hash + Objects.hashCode(this.student);
        hash = 59 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

}
