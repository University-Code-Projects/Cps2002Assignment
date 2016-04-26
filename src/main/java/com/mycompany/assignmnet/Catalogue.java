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
    private ArrayList<Book> book ;

    public Catalogue(){
        book = new ArrayList<Book>();
    }

    //private int size;

    public boolean newBookInfo(int isbn, String title, String author, int edition, Genre genre, int yrOfPub){
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
    
    public boolean removeBook(Book deleteBook){
        if(validBook(deleteBook)){
            book.remove(deleteBook);
            return true;
        }else{
            System.err.println("Error : Book does not exist");
            return false;
        }
    }
    
    public void printAllBook(){
        for(Book temp : book){
            System.out.print("\nBook Title: "+ temp.getTitle());
            System.out.print("\tAuthor: "+ temp.getAuthor());
            System.out.print("\tISBN: "+ temp.getIsbn());
            System.out.print("\tEdition: "+ temp.getEdition());
            System.out.print("\tGenre: "+ temp.getGenre());
            System.out.print("\tYear of Publication: "+ temp.getYrOfPub());
        }
    }
    
    public ArrayList<Book> getAllBook(){
        return book;
    }
    
    public ArrayList<Book> searchByTitle(String name){
        System.out.println("Entry in searchBy ..... in cat.java");
        
        ArrayList<Book> titles = new ArrayList<Book>();
        name = name.toLowerCase();
        System.out.println("Name = " + name);
        for(Book temp : book){
            if(temp.getTitle().toLowerCase().contains(name)){
                titles.add(temp);
            }
        }
        System.out.println(titles.size());
        return titles;
    }
}