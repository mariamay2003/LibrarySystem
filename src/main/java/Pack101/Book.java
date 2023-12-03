/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

/**
 *
 * @author maria
 */
public class Book implements Display{
    private BirthDate date;
    private Author author;
    private String title;
    private int no;
    private String genre;
    private int version;
    private int count;

    public Book() {
    }

    public Book(BirthDate date, Author author, String title, int no, String genre, int version, int count) {
        this.date = date;
        this.author = author;
        this.title = title;
        this.no = no;
        this.genre = genre;
        this.version = version;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public boolean inLoan()
    {
        return count <= 3;    
    }

    @Override
    public String getInfo() {
        return "Title :"+this.title+" ,Author :"+this.author+" ,No :"+this.no+" ,Genre :"+this.genre+" ,Version :"
        +this.version+" ,Date :"+this.date;
    }
}
