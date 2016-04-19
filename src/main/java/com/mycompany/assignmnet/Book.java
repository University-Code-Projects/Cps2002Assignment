/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmnet;

import java.util.*;
/**
 *
 * @author jonathan
 */
public class Book {
       
    private int isbn;
    private String title;
    private String author;
    private int edition;
    private Genre genre;
    private Date yrOfPub;

    public Book() {
        this.isbn = 0;
        this.title = "";
        this.author = "";
        this.edition = 0;
        this.genre = null;
        this.yrOfPub = new Date();
    }
    
    public Book(int isbn, String title, String author, Genre genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
      
    public Book(int isbn, String title, String author, int edition, Genre genre, Date yrOfPub) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.genre = genre;
        this.yrOfPub = yrOfPub;
    }
    
    public int getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getEdition() {
        return edition;
    }

    public Genre getGenre() {
        return genre;
    }

    public Date getYrOfPub() {
        return yrOfPub;
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setYrOfPub(Date yrOfPub) {
        this.yrOfPub = yrOfPub;
    }
}

