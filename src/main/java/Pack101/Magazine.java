/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

/**
 *
 * @author maria
 */
public class Magazine extends Book {

    private int issueNo;
    private BirthDate releaseDate;

    public Magazine() {
    }

    public Magazine(BirthDate date, Author author, String title, int no, String genre, int version, int issueNo, BirthDate releaseDate) {
        super(date, author, title, no, genre, version);
        this.issueNo = issueNo;
        this.releaseDate = releaseDate;
    }

    public Magazine(BirthDate date, Author author, String title, int no, String genre, int version) {
        super(date, author, title, no, genre, version);
    }

    public Magazine(int issueNo, BirthDate date, Author author, String title, int no, String genre, int version) {
        super(date, author, title, no, genre, version);
        this.issueNo = issueNo;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public BirthDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(BirthDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " ,issueNo :" + this.issueNo + " ,ReleaseDate :" + this.releaseDate;
    }

    @Override
    public String toString() {
        return "Magazine{" + "issueNo=" + issueNo + ", releaseDate=" + releaseDate + '}';
    }

}
