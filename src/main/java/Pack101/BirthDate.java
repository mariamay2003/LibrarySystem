/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class BirthDate implements Serializable {

    private int day;
    private int month;
    private int year;

    public BirthDate() {
    }

    public BirthDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static BirthDate fromString(String dateString) {
        String[] dateParts = dateString.split("/");
        if (dateParts.length == 3) {
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);
            return new BirthDate(day, month, year);
        } else {
            throw new IllegalArgumentException("Invalid date format: " + dateString);
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {

        this.day = day;

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

}
