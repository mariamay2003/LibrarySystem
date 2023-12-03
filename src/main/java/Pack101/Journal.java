/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

/**
 *
 * @author maria
 */
public class Journal extends Book {
    private String conferenceName;
    private int conferenceNo;

    public Journal() {
    }

    public Journal(String conferenceName, int conferenceNo, BirthDate date, Author author, String title, int no, String genre, int version, int count) {
        super(date, author, title, no, genre, version, count);
        this.conferenceName = conferenceName;
        this.conferenceNo = conferenceNo;
    }
    

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public int getConferenceNo() {
        return conferenceNo;
    }

    public void setConferenceNo(int conferenceNo) {
        this.conferenceNo = conferenceNo;
    }

    @Override
    public String getInfo() {
        return super.getInfo()+" ,ConferenceName :"+this.conferenceName+" ,ConferenceNo :"+this.conferenceNo;
    }
}
