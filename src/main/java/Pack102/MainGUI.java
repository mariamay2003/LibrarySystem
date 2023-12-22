/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack102;

import Pack101.DataManager;
import Pack101.Library;

/**
 *
 * @author maria
 */
public class MainGUI {

    // Create a registration system object
    public static Library library;

    public static void main(String[] args) {
        library = new Library();
        library.setBooks(DataManager.loadBooksFromFile());
        new main().setVisible(true);
    }
}
