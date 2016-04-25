/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.assignmnet;

import java.util.ArrayList;
import java.text.SimpleDateFormat;

/**
 *
 * @author jonathan
 */
public class Library {
    private ArrayList<Book> book;
    private Catalogue cat;
    
    private ArrayList<User> users;
    
    public Library(){
        users = new ArrayList<User>();
        book = new ArrayList<Book>();
        cat = new Catalogue();
    }
    
    public void Book(int choice, Book book){
        switch(choice){
            case 1 : 
                cat.newBookInfo(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getEdition(), book.getGenre(), book.getYrOfPub());
                break;
            case 2 : 
                cat.removeBook(book);
                break;
            case 3 : 
                cat.getAllBook();
                break;
            default : 
                System.err.println("Invalid Entry");
                break;
        }
    }
    
    public Book getBook(int isbn){
        
        return null;
    }
    
    public boolean newUserInfo(String name, String surname, String address, String email, int id, String nationality, SimpleDateFormat dob){
        User newUser = new User(name, surname, address, email, id, nationality, dob);
        if(validUser(newUser)){
            System.err.println("User already exists");
            return false;
        }else{
            addUser(newUser);
            return true;
        }
    }
    
    public boolean newUserInfo(String name, String surname, int id){
        User newUser = new User(name, surname, id);
        if(validUser(newUser)){
            System.err.println("User already exists");
            return false;
        }else{
            addUser(newUser);
            return true;
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
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean loanTo(Book book, User user, SimpleDateFormat loanDate){
        if((cat.validBook(book))&&(validUser(user))){
            book.setLoan(user, loanDate);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean returnBook(Book book){
        if(cat.validBook(book)){
            book.setLoan(null, null);
            return true;
        }else{
            return false;
        }
    }   
}
