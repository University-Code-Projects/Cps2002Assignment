/**
 * User Class
 * @author Jonathan Borg and Karl Farrugia
 */
package com.mycompany.assignmnet;
import java.util.*;

public class User {
    
    //Variables needed for each differnt user
    private String name;                //Name of the user
    private String surname;             //Surname of the user
    private int id;                     //Personal ID of the User
    private int libId;                  //Library ID of the user, given automatically
    private ArrayList<Book> loanBook;   //Number of Books the user loaned out on his name
    
    //default constructor
    public User(){
        this.name = "";
        this.surname = "";
        this.id = 0;
        loanBook = new ArrayList<Book>();
    }
    
    //constructor
    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        loanBook = new ArrayList<Book>();
    }
    
    //Getters
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
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setLibId(int libId) {
        this.libId = libId;
    }
    
    public void setLoanBook(Book loanBook1) {
        loanBook.add(loanBook1);
    }
}
