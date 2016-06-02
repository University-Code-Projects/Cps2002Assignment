/**
 *
 * @author Jonathan Borg and Karl Farrugia
 */
package com.mycompany.assignmnet;
import java.text.SimpleDateFormat;
import java.util.*;

public class Book {
    
    //Variables needed for each differnt book
    private int isbn;                   //Book Id
    private String title;               //Book title
    private String author;              //Book author
    private int edition;                //Book edition number
    private Genre genre;                //Book Genre
    private int yrOfPub;                //Year of Publication of the Book
    private User loanTo;                //To whom the book is loaned
    private SimpleDateFormat loanDate;  //When the Book was loaned out
    private ArrayList<User> wantingBook;//Users that are on the waiting list for the specific book
    
    //default constructor
    public Book() {
        this.isbn = 0;
        this.title = "";
        this.author = "";
        this.edition = 0;
        this.genre = null;
        this.yrOfPub = 0;
        this.loanTo = null;
        this.loanDate = new SimpleDateFormat("01/01/1999 12:00:00");
        this.wantingBook = new ArrayList<User>();
    }
    
    //constructor
    public Book(int isbn, String title, String author, int edition, Genre genre, int yrOfPub) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.genre = genre;
        this.yrOfPub = yrOfPub;
        this.loanTo = null;
        this.loanDate = new SimpleDateFormat("01/01/1999 12:00:00");
        this.wantingBook = new ArrayList<User>();
    }
    
    //Getters
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
    
    public int getYrOfPub() {
        return yrOfPub;
    }
    
    public User getLoanTo() {
        return loanTo;
    }
    
    public SimpleDateFormat getLoanDate() {
        return loanDate;
    }
    
    public ArrayList<User> getWantingBook() {
        return wantingBook;
    }
    
    //Setters
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
    
    public void setYrOfPub(int yrOfPub) {
        this.yrOfPub = yrOfPub;
    }
    
    public void setLoan(User loanTo, SimpleDateFormat loanDate) {
        this.loanTo = loanTo;
        this.loanDate = loanDate;
    }

    public void setWantingBook(ArrayList<User> wantingBook) {
        this.wantingBook = wantingBook;
    }
}

