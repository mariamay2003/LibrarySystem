/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author maria
 */
public class Student {

    private String major;
    private int id;
    private String name;
    private String address;
    private BirthDate bd;
    private ArrayList<Book> loans;
    private Loan lo;
    Calendar c = Calendar.getInstance();

    public Student() {
        loans = new ArrayList<>();
    }

    public Student(String major, int id, String name, String address, BirthDate bd, Loan lo) {
        this.major = major;
        this.id = id;
        this.name = name;
        this.address = address;
        this.bd = bd;
        this.lo = lo;
    }

    public Student(String major, int id, String name, String address, BirthDate bd) {
        this.major = major;
        this.id = id;
        this.name = name;
        this.address = address;
        this.bd = bd;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BirthDate getBd() {
        return bd;
    }

    public void setBd(BirthDate bd) {
        this.bd = bd;
    }

    public ArrayList<Book> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Book> loans) {
        this.loans = loans;
    }

    public Loan getLo() {
        return lo;
    }

    public void setLo(Loan lo) {
        this.lo = lo;
    }

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equals(this.major, other.major);
    }

    public boolean loanBooks(Book book) {
        if (loans.size() < 3) {
            loans.add(book);
            return true;
        }
        return false;
    }

    public int countDays() {
        int day = c.get(Calendar.DAY_OF_MONTH);
        BirthDate d = lo.getDueDate();
        int totDays = Math.abs(day - d.getDay());
        return totDays;
    }

    // Method to calculate the number of books a student has loaned
    public int numberOfBooksLoaned() {
        if (loans == null) {
            return 0;
        }
        return loans.size();
    }

    public boolean returnBooks(Book book) {
        return loans.remove(book);
    }

    @Override
    public String toString() {
        return "Student{" + "major=" + major + ", id=" + id + ", name=" + name + ", address=" + address + ", bd=" + bd + ", loans=" + loans + ", lo=" + lo + ", c=" + c + '}';
    }

}
