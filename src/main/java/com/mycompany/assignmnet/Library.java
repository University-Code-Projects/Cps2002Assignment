/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmnet;

/**
 *
 * @author jonathan
 */
public class Library {
    private Book book;
    private Catalogue cat;
    private User user;
    
    public Library(){
        user = new User();
        book = new Book();
        cat = new Catalogue();
    }
    
}
