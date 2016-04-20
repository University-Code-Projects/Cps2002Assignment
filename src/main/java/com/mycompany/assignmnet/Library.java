/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.assignmnet;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jonathan
 */
public class Library {
    private Book book;
    private Catalogue cat;
    
    private ArrayList<User> users;
    
    public Library(){
        users = new ArrayList<User>();
        book = new Book();
        cat = new Catalogue();
    }
    
    public void newUserInfo(String name, String surname, String address, String email, int id, String nationality, Date dob){           
        User newUser = new User(name, surname, address, email, id, nationality, dob);
        if(validUser(newUser)){
            System.err.println("User already exists");
        }else{
            addUser(newUser);
        }
    }
    
    public void addUser(User newUser){
        User user = new User();
        if(!users.isEmpty()){
            user = users.get(users.size() - 1); 
            int i = user.getLibId();
            user.setLibId(++i);
        }else{
            int i = 0;
            user.setLibId(++i);
        }
        
        
        users.add(newUser);
    }
    
    public boolean validUser(User check){
        int id = check.getId();
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
                }
            }
        }
        
        return flag;
    }
    
    public boolean removeUser(User deleteUser){
        int librId = deleteUser.getLibId();//the id of user to be deleted
        boolean flag = false;
        if(users.size() <=0){//list is empty
            return flag;
        }else{
            if(validUser(deleteUser)){
                users.remove(deleteUser);
            }
        } 
        return flag;
    }
}
