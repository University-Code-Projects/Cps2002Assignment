/**
 * Library Class
 * @author Jonathan Borg and Karl Farrugia
 */
package com.mycompany.assignmnet;
import java.util.*;
import java.text.*;

public class Library {
    //Variables that the Library Stores in it
    private Catalogue cat;              //Library can have only 1 catalogue
    private ArrayList<User> users;      //List of users in the library
    
    //Default Constructor
    public Library(){
        users = new ArrayList<User>();
        cat = new Catalogue();
    }

    //Constructor to set the library with a default set of users and number of books in catalogue
     public Library(ArrayList<User> users,Catalogue cat){
        this.users = users;
        this.cat = cat;
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
    
    /*
        Composite design pattern
    */
    public ArrayList<Book> searchForBooks(ArrayList<Book> allBooks, ArrayList<Book> searchResult, String title, int year, Genre genre){
        if(!title.isEmpty()){
            searchResult = new ArrayList<Book>();
            title = title.toLowerCase();
            for(Book temp : allBooks){
                if(temp.getTitle().toLowerCase().contains(title)){
                    searchResult.add(temp);
                }
            }
            title = "";
        }else if(year > 0){
            searchResult = new ArrayList<Book>();
            for(Book temp : allBooks){
                if(temp.getYrOfPub() == year){
                    searchResult.add(temp);
                }
            }
            year = 0;
        }else if(genre != null){
            searchResult = new ArrayList<Book>();
            for(Book temp : allBooks){
                if(temp.getGenre() == genre){
                    searchResult.add(temp);
                }
            }
            genre = null;
        }else{
            return searchResult;
        }
        //allBooks = searchResult;
        return searchForBooks(searchResult,searchResult,title,year,genre);
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
    
    public ArrayList<Book> getAllBook(){
        return cat.getAllBook();
    }
    
    public boolean loanTo(Book book, User user, SimpleDateFormat loanDate){
        Date date = new Date();
        if((cat.validBook(book))&&(validUser(user))){
            boolean flag = true;
            if(user.getLoanBook().size() > 0){
                ArrayList<Book> books = user.getLoanBook();
                for(Book temp : books){
                    SimpleDateFormat loan = temp.getLoanDate();
                    SimpleDateFormat current = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    String start = loan.format(date);
                    String end = current.format(date);
                    Date entry = null;
                    Date curr = null;
                    try {
                        entry = format.parse(start);
                        curr = format.parse(end);
                        double differnce = curr.getTime() - entry.getTime();
                        double diffinDays = differnce / (24 * 60 * 60 * 1000);
                        if(diffinDays > 28){
                            flag = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            
            if(flag){
                if(book.getLoanTo() == null){
                    if(user.getLoanBook().size() < 3){
                        book.setLoan(user, loanDate);
                        user.setLoanBook(book);
                        return true;               
                    }
                }else{
                    ArrayList<User> waitingUsers = book.getWantingBook();
                    waitingUsers.add(user);
                    book.setWantingBook(waitingUsers);
                    return false;
                }
            }
            return false;
         }else{
            return false;
        }
    }
    
    public boolean returnBook(Book bookL){
        boolean deleted = false;
        if(cat.validBook(bookL)){
            if(bookL.getLoanTo() != null){
                ArrayList<Book> loanedBooks = bookL.getLoanTo().getLoanBook();
                for(Book temp : loanedBooks){
                    if(temp == bookL){
                        loanedBooks.remove(temp);
                        temp.setLoan(null, null);
                        ArrayList<User> waitingUsers = temp.getWantingBook();                       
                        
                        if(!waitingUsers.isEmpty()){
                            System.out.println("User: '" + waitingUsers.get(0).getName()+ "' with ID: '"+ waitingUsers.get(0).getId()+ "' now the book '" + temp.getTitle()+"' is available for borrowing");
                            waitingUsers.remove(0);
                        }
                        bookL.setWantingBook(waitingUsers);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
