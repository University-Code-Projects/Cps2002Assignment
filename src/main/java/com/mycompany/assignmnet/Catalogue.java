/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmnet;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author jonathan
 */
public class Catalogue {
    private ArrayList<ArrayList<Genre>> listOfGenres = new ArrayList<ArrayList<Genre>>();
    private ArrayList<Genre> singleGenre = new ArrayList<Genre>();
    private ArrayList<Book> book ;

    public Catalogue(){
        listOfGenres = null;
        singleGenre = null;
        book = new ArrayList<Book>();
    }

    //private int size;

    public boolean newBookInfo(int isbn, String title, String author, int edition, Genre genre, SimpleDateFormat yrOfPub){
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
        for(Book temp : book){
            if(temp.getIsbn() == isbn){
                flag = true;
                break;
            }
        }
        return flag;
    }

    
    public void addBook(Book newBook){
        book.add(newBook);
    }
    
    public boolean removeUser(User deleteUser){
        return false;
    }
    
    public void getAllBook(){
        for(Book temp : book){
            System.out.println("Book Title: "+ temp.getTitle());
            System.out.print("\tAuthor: "+ temp.getAuthor());
            System.out.print("\tISBN: "+ temp.getIsbn());
            System.out.print("\tEdition: "+ temp.getEdition());
            System.out.print("\tGenre: "+ temp.getGenre());
            System.out.print("\tYear of Publication: "+ temp.getYrOfPub());
        }
    }
}
