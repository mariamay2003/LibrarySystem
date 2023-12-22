/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author maria
 */
public class Book implements Display, Serializable {

    private BirthDate date;
    private Author author;
    private String title;
    private int no;
    private String genre;
    private int version;
    private int count;

    public Book() {
    }

    public Book(BirthDate date, Author author, String title, int no, String genre, int version) {
        this.date = date;
        this.author = author;
        this.title = title;
        this.no = no;
        this.genre = genre;
        this.version = version;
        count++;
    }

    public Book(int no) {
        this.no = no;
    }

    public BirthDate getDate() {
        return date;
    }

    public void setDate(BirthDate date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean inLoan() {
        return count <= 3;
    }

    @Override
    public String getInfo() {
        return "Title :" + this.title + " ,Author :" + this.author + " ,No :" + this.no + " ,Genre :" + this.genre + " ,Version :"
                + this.version + " ,Date :" + this.date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Book other = (Book) obj;
        if (this.no != other.no) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.author, other.author);
    }

    @Override
    public String toString() {
        return date.toString() + "," + author + "," + title + "," + no + "," + genre + "," + version ;
    }

}
