/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmnet;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author jonathan
 */
public class User {
    
    private String name;
    private String surname;
    private String address;
    private String email;
    private int id;
    private String nationality;
    private SimpleDateFormat dob; 
    private int libId;
    private ArrayList<Book> loanBook;

    public User(){
    }

    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.address = "Unknown";
        this.address = "Unknown";
        loanBook = new ArrayList<Book>();
    }

    public User(String name, String surname, String address, String email, int id, String nationality, SimpleDateFormat dob) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.id = id;
        this.nationality = nationality;
        this.dob = dob;
        loanBook = new ArrayList<Book>();
    }
    
    
    public void setUserId(int id){
        this.libId = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public int getLibId() {
        return libId;
    }

    public ArrayList<Book> getLoanBook() {
        return loanBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDob(SimpleDateFormat dob) {
        this.dob = dob;
    }   

    public void setLibId(int libId) {
        this.libId = libId;
    }

    public void setLoanBook(Book loanBook1) {
        loanBook.add(loanBook1);
    }
}
