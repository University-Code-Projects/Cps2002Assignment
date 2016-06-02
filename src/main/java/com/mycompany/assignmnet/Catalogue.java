/**
 * Catalogue Class
 * @author Jonathan Borg and Karl Farrugia
 */
package com.mycompany.assignmnet;
import java.util.*;

public class Catalogue {
    private ArrayList<Book> book ;//all the books in the catalogue

    //default constructor
    public Catalogue(){
        book = new ArrayList<Book>();
    }
    
    //checks the information given against all previous books (isbn)
    public boolean newBookInfo(int isbn, String title, String author, int edition, Genre genre, int yrOfPub){
        Book newBook = new Book(isbn, title, author, edition, genre, yrOfPub);
        if(validBook(newBook)){//if it is a valid book, it already exists
            System.err.println("Book already exists");
            return false;
        }else{
            addBook(newBook);//adding the book to the list using the addBook method
            return true;
        }
    }
    
    //check if a book already exists
    public boolean validBook(Book check){
        int isbn = check.getIsbn();
        boolean flag = false;
        for(Book temp : book){
            if(temp.getIsbn() == isbn){//if isbn matches, the book already exists
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    //adding the book to the array list
    public void addBook(Book newBook){
        book.add(newBook);
    }
    
    //removing the book from the list
    public boolean removeBook(Book deleteBook){
        if(validBook(deleteBook)){  //checking that the book is valid
            book.remove(deleteBook);
            return true;
        }else{
            System.err.println("Error : Book does not exist");
            return false;
        }
    }
    

    /*
    //method used for debugging by displaying the books
    public void printAllBook(){
        for(Book temp : book){
            System.out.print("\nBook Title: "+ temp.getTitle());
            System.out.print("\tAuthor: "+ temp.getAuthor());
            System.out.print("\tISBN: "+ temp.getIsbn());
            System.out.print("\tEdition: "+ temp.getEdition());
            System.out.print("\tGenre: "+ temp.getGenre().getGenre());
            System.out.println("\tYear of Publication: "+ temp.getYrOfPub());
        }
    }
    */

    //returning all the books in the arrayList
    public ArrayList<Book> getAllBook(){
        return book;
    }
}