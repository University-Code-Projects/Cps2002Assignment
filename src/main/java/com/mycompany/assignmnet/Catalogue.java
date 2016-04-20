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
public class Catalogue {
    private ArrayList<ArrayList<Genre>> listOfGenres = new ArrayList<ArrayList<Genre>>();
    private ArrayList<Genre> singleGenre = new ArrayList<Genre>();

    public Catalogue(){
        listOfGenres = null;
        singleGenre = null;
    }

    //private int size;

    public boolean newBookInfo(int isbn, String title, String author, int edition, Genre genre, Date yrOfPub){
        Book newBook = new Book(isbn, title, author, edition, genre, yrOfPub);
        if(validBook(newBook)){
            System.err.println("Book already exists");
            return false;
        }else{
            addBook(newBook);
            return true;
        }
    }
    
    public boolean validBook(Book check){
        int isbn = check.getIsbn();
        boolean flag = false;
        int size;

        return flag;
    }

    
    public void addBook(Book newBook){
        
    }
    
    public boolean removeUser(User deleteUser){
        return false;
    }
    
    public void getAllBook(){
        
        
    }
}
