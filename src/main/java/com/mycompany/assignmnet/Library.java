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
    
     //Default Method used to call the add, remove or get book
     //Using the variable choice, which is hardcoded, the program chooses what is to be done with the parameter book1 passes
    public void Book(int choice, Book book1){
        switch(choice){
            case 1 :    //adding a new book
                cat.newBookInfo(book1.getIsbn(), book1.getTitle(), book1.getAuthor(), book1.getEdition(), book1.getGenre(), book1.getYrOfPub());
                break;
            case 2 :    //removing a book
                cat.removeBook(book1);
                break;
            case 3 :    //getting the data about the book
                getBook(book1.getIsbn());
                break;
        }
    }
    
    //Get the Book from the Catalogue
    public Book getBook(int isbn){
        ArrayList<Book> books = cat.getAllBook();   //using the method in getAllBooks
        for(Book temp : books){                     //iterating through the books
            if(temp.getIsbn() == isbn){
                return temp;
            }
        }
        return null;
    }
    
    /*
     *   Composite design pattern
     *   Brief: Used to search through a given number of filters to find the books that satisfy those filters
     *   Implementation: This is a recursive method that checks each given filter.
     *                   If the filter is not empty it gets all the books satisfying the requirments and adds them to ArrayList to be returned.
     *                   Afterwards this is done, it calls itself while removing the current filter done.
     *                   This is repeated for 3 times (maximum), for each differnt filter
     *   Parameters: 
     *      ---> allBooks:      The books which the search will be done on
     *      ---> searchResult:  The result obtained from the search which was made
     *      ---> title:         The title which will be search for (type of filter)
     *      ---> year:          The publishing date of the book (type of filter)
     *      ---> genre:         The genre of the book (type of filter)
    */     
    public ArrayList<Book> searchForBooks(ArrayList<Book> allBooks, ArrayList<Book> searchResult, String title, int year, Genre genre){
        if(!title.isEmpty()){                       //checking the title
            searchResult = new ArrayList<Book>();
            title = title.toLowerCase();
            for(Book temp : allBooks){              //iterating through all the books given
                if(temp.getTitle().toLowerCase().contains(title)){
                    searchResult.add(temp);         //adding to the array list if the title matches
                }
            }
            title = "";                             //removing the filter
        }else if(year > 0){                         ///checking the year of publication
            searchResult = new ArrayList<Book>();
            for(Book temp : allBooks){
                if(temp.getYrOfPub() == year){
                    searchResult.add(temp);         //adding to the array if the year matches
                }
            }
            year = 0;                               //removing the filter
        }else if(genre != null){                    //checking the genre
            searchResult = new ArrayList<Book>();
            for(Book temp : allBooks){
                if(temp.getGenre() == genre){
                    searchResult.add(temp);         //adding to the array if the genre matches
                }
            }
            genre = null;
        }else{
            return searchResult;                    //returning the parameter given
        }
        //the function calls itself, but on the search result newly found as allBooks, thus
        //always reducing the number of books found per filter, as they have less books to iterate through it
        return searchForBooks(searchResult,searchResult,title,year,genre);
    }
    
    //adding a new user to the library
    public boolean newUserInfo(String name, String surname, int id){
        User newUser = new User(name, surname, id);//creating the user object
        if(validUser(newUser)){     //trying to inser a user that already exists
            System.err.println("User already exists");
            return false;
        }else{
            addUser(newUser);       //adding the user using the function addUser
            return true;
        }
    }
    
    //add the user to the list of users the library stores in it
    public void addUser(User newUser){
        User user = new User();
        int i = 0;
        if(!users.isEmpty()){
            user = users.get(users.size() - 1); //get the last object in the list
            i = user.getLibId();                //obtaining the last objects library id
            user.setLibId(++i);                 //setting the library id of the new user to +1 of the last user in the list
        }else{
            user.setLibId(++i);                 //setting the library id of the new user to 1
        }
        users.add(newUser);                     //adding the user to the array list
    }
    
    //checking of the user given is valid or not through the ID of the user
    public boolean validUser(User check){
        int id = check.getId();
        boolean flag = false;
        int size;
        if(users == null){
            size = 0;
        }else{
            size = users.size();
            for(User temp : users){
                if(temp.getId() == id){//a user with same id was found, thus it is a valid user
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    
    //remove a user from the array list
    public boolean removeUser(User deleteUser){
        int librId = deleteUser.getLibId();//the id of user to be deleted
        boolean flag = false;
        if(users.size() <=0){//list is empty
            return flag;
        }else{
            if(validUser(deleteUser)){//check if the user given is valid using the method validUser()
                users.remove(deleteUser);
                flag = true;
            }
        }
        return flag;
    }
    
    //using the function created in catalogue
    public ArrayList<Book> getAllBook(){
        return cat.getAllBook();
    }
    
    //loaning a book to a specific user
    public boolean loanTo(Book book, User user, SimpleDateFormat loanDate){
        Date date = new Date();
        if((cat.validBook(book))&&(validUser(user))){           //check if the user and book given are valid
            boolean flag = true;
            if(user.getLoanBook().size() > 0){                  //the specified user already has one or more books loaned out to him
                ArrayList<Book> books = user.getLoanBook();     //get all the books loaned out to the user
                for(Book temp : books){                         //iterate through them
                    SimpleDateFormat loan = temp.getLoanDate(); //get the date of loan of a book
                    SimpleDateFormat current = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); //format of store the current date (day which is being checked)
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  //format of the day when the book was loaned out
                    String start = loan.format(date);           //setting the starting day of when the book was loaned
                    String end = current.format(date);          //setting the current day
                    Date entry = null;
                    Date curr = null;
                    try {
                        entry = format.parse(start);            
                        curr = format.parse(end);
                        double differnce = curr.getTime() - entry.getTime();                //comparing the difference between start and end date
                        double diffinDays = differnce / (24 * 60 * 60 * 1000);              //obtaining the difference in days
                        if(diffinDays > 28){                                                //checking that the loan out was less than 28 days (as required)
                            flag = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            
            if(flag){                                           //only false if the user has a book loaned out for more than 28 days
                if(book.getLoanTo() == null){                   //the book is not loaned out to anyone
                    if(user.getLoanBook().size() < 3){          //the user does not have more than 3 books loaned out
                        book.setLoan(user, loanDate);           //setting the date for the book to be loaned out to the user
                        user.setLoanBook(book);                 //loaning the book to the user
                        return true;               
                    }
                }else{
                    //Task 3 of assignment part 2
                    ArrayList<User> waitingUsers = book.getWantingBook();   //the book is already loaned out to another user
                    waitingUsers.add(user);                                 //adding this user to the waiting list of the book
                    book.setWantingBook(waitingUsers);
                    return false;
                }
            }
            return false;
         }else{
            return false;
        }
    }
    
    //returning a book to the library
    public boolean returnBook(Book bookL){
        if(cat.validBook(bookL)){               //check that the book is valid
            if(bookL.getLoanTo() != null){      //since returning, the book should be loaned out to a user
                ArrayList<Book> loanedBooks = bookL.getLoanTo().getLoanBook();
                for(Book temp : loanedBooks){   //iterating through all the books that are loaned out to the user, that has the current book loaned out on his name
                    if(temp == bookL){
                        loanedBooks.remove(temp);   //removing the book from the array list of the user (loanBook)
                        temp.setLoan(null, null);   //since it is returned, setting all the loan data to null
                        
                        //Task 3 of assignment part 2
                        ArrayList<User> waitingUsers = temp.getWantingBook();   //get all the users that want this specific book
                        if(!waitingUsers.isEmpty()){
                            //notifying the user that the book is available
                            System.out.println("User: '" + waitingUsers.get(0).getName()+ "' with ID: '"+ waitingUsers.get(0).getId()+ "' now the book '" + temp.getTitle()+"' is available for borrowing");
                            waitingUsers.remove(0);     //removing the first user from list of users that want the book, as the user has been notified
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
