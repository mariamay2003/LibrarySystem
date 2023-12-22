/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pack101;

import java.io.Serializable;

/**
 *
 * @author maria
 */
public class Author implements Serializable {

    private int id;
    private String name;
    private String address;
    private BirthDate bd;

    public Author() {
    }

    public Author(int id, String name, String address, BirthDate bd) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bd = bd;
    }

    public static Author fromString(String authorString) {
        String[] authorParts = authorString.split("-");
        int id = Integer.parseInt(authorParts[0]);
        String name = authorParts[1];
        String address = authorParts[2];
        BirthDate bd = BirthDate.fromString(authorParts[3]);
        return new Author(id, name, address, bd);
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
        this.bd = new BirthDate(0, 0, 0);
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

    @Override
    public String toString() {
        return id + "/" + name + "/" + address + "/" + bd.toString();
    }

    public String writeAuthor() {
        return id + "-" + name + "-" + address + "-" + bd.toString();
    }

}
