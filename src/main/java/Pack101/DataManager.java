/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class DataManager {

    private static final String FILEPATH = "C:\\Users\\maria\\OneDrive\\Documents\\NetBeansProjects\\LibraryRegstrationSystem\\book.txt";

    
    // Method to load data from a text file to ArrayList<Book>
    public static ArrayList<Book> loadBooksFromFile() {
        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into individual fields using a delimiter
                String[] fields = line.split(",");

                BirthDate date = BirthDate.fromString(fields[0]);
                Author author = Author.fromString(fields[1]);
                String title = fields[2];
                int no = Integer.parseInt(fields[3]);
                String genre = fields[4];
                int version = Integer.parseInt(fields[5]);
                //System.out.println(fields.length);

                if (fields.length == 9) {
                    // Journal
                    String conferenceName = fields[6];
                    int conferenceNo = Integer.parseInt(fields[7]);
                    Journal journal = new Journal(conferenceName, conferenceNo, date, author, title, no, genre, version);
                    books.add(journal);
                    
                } else if (fields.length == 8) {
                    // Magazine
                    int issueNo = Integer.parseInt(fields[6]);
                    BirthDate releaseDate = BirthDate.fromString(fields[7]);
                    Magazine magazine = new Magazine(date, author, title, no, genre, version, issueNo, releaseDate);
                    books.add(magazine);
                } else {
                    // Book
                    Book book = new Book(date, author, title, no, genre, version);
                    books.add(book);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Data loaded from file Failed!");
        }
        if(!books.isEmpty())
            System.out.println("Data loaded from file Success!");

        return books;
    }

    // Method to save data from ArrayList<Book> to a text file
    public static void saveBooksToFile(ArrayList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))) {
            for (Book book : books) {
                String line = book.getDate() + "," + book.getAuthor().writeAuthor() + "," + book.getTitle() + ","
                        + book.getNo() + "," + book.getGenre() + "," + book.getVersion();
                if (book instanceof Magazine) {
                    Magazine magazine = (Magazine) book;
                    line += "," + magazine.getIssueNo() + "," + magazine.getReleaseDate();
                } else if (book instanceof Journal) {
                    Journal journal = (Journal) book;
                    line += "," + journal.getConferenceName() + "," + journal.getConferenceNo()+ ", J";
                }
                System.out.println(line);
                writer.write(line);
                writer.newLine();
                //System.out.println("Data write to file Success!");
            }
        } catch (IOException e) {
            System.out.println("Data write to file Failed!");
            e.printStackTrace();
        }
    }
}
