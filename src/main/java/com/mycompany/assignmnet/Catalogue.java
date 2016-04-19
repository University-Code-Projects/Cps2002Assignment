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

    public void addBook(Book book){
        Genre gen = book.getGenre();
        
    }
    
    public void getAllBook(){
        
        
    }
}
