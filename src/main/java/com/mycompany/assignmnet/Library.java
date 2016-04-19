/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.assignmnet;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class Library {
    private Book book;
    private Catalogue cat;
    //private User user;
    
    private ArrayList<User> users = new ArrayList<User>();
    
    public Library(){
        users = new ArrayList<User>();
        book = new Book();
        cat = new Catalogue();
    }
    
    public void addUser(User newUser){
            users.add(newUser);
        
    }
    
    public boolean validUser(int id){
        boolean flag = false;
        int size;
        if(users == null){
            size = 0;
        }else{
            size = users.size();
            for(User temp : users){
                if(temp.getId() == id){
                    flag = true;
                    break;
                }else{
                    continue;
                }
            }
        }
        
        return flag;
    }
    
    
    
}
