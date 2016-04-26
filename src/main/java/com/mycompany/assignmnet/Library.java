/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.assignmnet;

import java.util.*;
import java.text.*;

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
    
    public void Book(int choice, Book book1){
        switch(choice){
            case 1 : 
                cat.newBookInfo(book1.getIsbn(), book1.getTitle(), book1.getAuthor(), book1.getEdition(), book1.getGenre(), book1.getYrOfPub());
                break;
            case 2 : 
                cat.removeBook(book1);
                break;
            case 3 : 
                getBook(book1.getIsbn());
                break;
            default : 
                System.err.println("Invalid Entry");
                break;
        }
    }
    
    public Book getBook(int isbn){
        ArrayList<Book> books = cat.getAllBook();
        for(Book temp : books){
            if(temp.getIsbn() == isbn){
                return temp;
            }
        }
        return null;
    }
    
    public ArrayList<Book> searchByTitle(String name){
        ArrayList<Book> books = cat.getAllBook();
        cat.searchByTitle(name);
        ArrayList<Book> titles = cat.searchByTitle(name);
        return titles;
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
        Date date = new Date();
        if((cat.validBook(book))&&(validUser(user))){
            System.out.println("User and Book are both valid, checking if the user given has more than 1 book stores in the loanBook");
            if(user.getLoanBook().size() > 0){
                ArrayList<Book> books = user.getLoanBook();
                SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");
                
                for(Book temp : books){
                    
                    //Date loanOut = dateformat.parse("17/07/2015");
                    
                    SimpleDateFormat loan = temp.getLoanDate();
                    SimpleDateFormat current = new SimpleDateFormat();
                    String start = loan.format(date);
                    String end = current.format(date);
                    System.out.println("Difference : " + start +"  end  "+ end);
                    
                    
                    //if()
                    System.out.print("\nBook Title: "+ temp.getTitle());
                    System.out.print("\tAuthor: "+ temp.getAuthor());
                    System.out.print("\tISBN: "+ temp.getIsbn());
                    System.out.print("\tEdition: "+ temp.getEdition());
                    System.out.print("\tGenre: "+ temp.getGenre());
                    System.out.print("\tYear of Publication: "+ temp.getYrOfPub());
                
                    
                }
                
            }else{
               book.setLoan(user, loanDate);                
               user.setLoanBook(book);
               System.out.println("loaned books = " + user.getLoanBook().size());
            
            }

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