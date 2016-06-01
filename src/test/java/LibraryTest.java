/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import com.mycompany.assignmnet.Library;
import com.mycompany.assignmnet.User;
import com.mycompany.assignmnet.Book;
import com.mycompany.assignmnet.Genre;
import com.mycompany.assignmnet.*;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonathan
 */
public class LibraryTest {
    
    public LibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    Library libr = new Library();
    Library libr2 = new Library();
    User user = new User("Test Name", "Test surname",1);
    User user2 = new User("Test Name", "Test surname",8956);
    Catalogue cat = new Catalogue();
    Book book = new Book();
    Genre genre = new Genre("Horror");
    SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("02/28/2012 12:00:00");
    int year = 2015;
    int year2 = 1996;
    
    @Before
    public void Library() {
        libr = new Library();
        libr2 = new Library();
        user = new User("Test Name", "Test surname",1);
        user2 = new User("Test Name", "Test surname",8956);
        
        book = new Book(123, "Life in CS", "Karl Borg", 1, genre, year);
        libr.addUser(user);
        cat.addBook(book);
    }
    
    @After
    public void Libray1() {
        libr = null;
        libr2 = null;
        cat = null;
        user = null;
        user2 = null;
    }
    @Test
    public void add_User() {//adding a new user with different id
        assertEquals(true,libr.newUserInfo("Test Name", "Test surname",2));
    }
    
    @Test
    public void add_User_1() {//user already exists since id already exists
        User user1 = new User("Test Name", "Test surname",1);
        assertEquals(false,libr.newUserInfo("Test Name", "Test surname",1));
    }
    
    @Test
    public void delete_User() {//delete an existing user
        User user1 = new User("Test Name", "Test surname",1);
        assertEquals(true,libr.removeUser(user1));
    }
    
    @Test
    public void delete_User1() {//delete a user that has been deleted already
        libr.removeUser(user);
        assertEquals(false,libr.removeUser(user));
    }
    
    @Test
    public void valid_User() {//checking for an invlaid user (since id was not set)
        User user1= new User();
        assertEquals(false,libr.validUser(user1));
    }
    
    @Test
    public void valid_User1() {//checking for a valid user
        User user1 = new User("Test Name", "Test surname",1);
        assertEquals(true,libr.validUser(user1));
    }
    
    @Test
    public void add_Book() {//adding a new book with different isbn
        assertEquals(true,cat.newBookInfo(1, "Life in CS", "Karl Borg", 1, genre, year));
    }
    
    @Test
    public void add_Book_1() {//user already exists since isbn already exists
        Book book1 = new Book(123, "Life in CS", "Karl Borg", 1, genre, year);
        assertEquals(false,cat.newBookInfo(123, "Life in CS", "Karl Borg", 1, genre, year));
    }
    
    @Test
    public void delete_Book() {//delete an existing book
        User user1 = new User("Test Name", "Test surname",1);
        assertEquals(true,libr.removeUser(user1));
    }
    
    @Test
    public void delete_Book1() {//delete a book that has been deleted already
        cat.removeBook(book);
        assertEquals(false,cat.removeBook(book));
    }
    
    @Test
    public void valid_Book() {//checking for an invlaid book (since isbn was not set)
        Book book1= new Book();
        assertEquals(false,cat.validBook(book1));
    }
    
    @Test
    public void valid_Book1() {//checking for a valid book
        assertEquals(true,cat.validBook(book));
    }
    
    @Test
    public void loan_To() {//checking for invalid loan out
        Book book1= new Book();
        assertEquals(false,libr.loanTo(book1, user, SimpleDateFormat));
    }
    
    @Test
    public void loan_To1() {//checking for a valid loan out
        User user1 = new User("Test Name", "Test surname",1);
        Book book1 = new Book(6854, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        assertEquals(true,libr.loanTo(libr.getBook(book1.getIsbn()) , user1, SimpleDateFormat));
    }
    
    @Test
    public void loan_To2() {//checking for a valid loan out
        Book book1 = new Book(6854, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(1232559, "Life in CS", "Karl Borg", 1, genre, year);
        Book book3 = new Book(17412568, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        libr.Book(1, book2);
        libr.Book(1, book3);
        
        libr.loanTo(book2, user, SimpleDateFormat);
        libr.loanTo(book3, user, SimpleDateFormat);
        libr.loanTo(book, user, SimpleDateFormat);
        assertEquals(false,libr.loanTo(libr.getBook(book1.getIsbn()) , user, SimpleDateFormat));
    }
    
    @Test
    public void loan_To3() {//checking for a valid loan out, user having more than 3 books
        Book book1 = new Book(8844, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(12968, "Life in CS", "Karl Borg", 1, genre, year);
        Book book3 = new Book(174128, "Life in CS", "Karl Borg", 1, genre, year);
        Book book4 = new Book(89, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        libr.Book(1, book2);
        libr.Book(1, book3);
        libr.Book(1, book4);
        
        SimpleDateFormat SimpleDateFormat1 = new SimpleDateFormat("04/22/2016 12:00:00");
        
        libr.loanTo(book2, user, SimpleDateFormat1);
        libr.loanTo(book3, user, SimpleDateFormat1);
        libr.loanTo(book4, user, SimpleDateFormat1);
        
        assertEquals(false,libr.loanTo(book1, user, SimpleDateFormat1));
    }
    
    @Test
    public void loan_To4() {//checking for a valid loan out, user having less than 3 books
        Book book1 = new Book(84, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(2, "Life in CS", "Karl Borg", 1, genre, year);
        Book book3 = new Book(18, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        libr.Book(1, book2);
        libr.Book(1, book3);
        
        SimpleDateFormat SimpleDateFormat1 = new SimpleDateFormat("04/22/2016 12:00:00");
        libr.loanTo(book2, user, SimpleDateFormat1);
        libr.loanTo(book1, user, SimpleDateFormat1);
        
        assertEquals(false,libr.loanTo(book3 , user, SimpleDateFormat1));
    }
    
    @Test
    public void loan_To5() {//checking for a valid loan out, user having less than 3 books and more than 28
        Book book1 = new Book(84, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(12968, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        libr.Book(1, book2);
        
        SimpleDateFormat SimpleDateFormat1 = new SimpleDateFormat("04/22/2016 12:00:00");
        
        libr.loanTo(book2, user2, SimpleDateFormat);
        libr.loanTo(book, user2, SimpleDateFormat1);
        
        assertEquals(false,libr.loanTo(libr.getBook(book1.getIsbn()) , user2, SimpleDateFormat1));
    }
    
    @Test
    public void loan_To6() {//checking for a valid loan out, when the book is already loaned out
        Book book1 = new Book(84, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(12968, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        libr.Book(1, book2);
        
        SimpleDateFormat SimpleDateFormat1 = new SimpleDateFormat("04/22/2016 12:00:00");
        
        libr.loanTo(book2, user2, SimpleDateFormat);
        libr.loanTo(book, user2, SimpleDateFormat1);
        
        assertEquals(false,libr.loanTo(book , user2, SimpleDateFormat1));
    }
    
    @Test
    public void search_Title() {//returning a list of books having a that title in their name
        ArrayList<Book> actual = new ArrayList<Book>();
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Life in CS", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "Life in CS", "Karl Borg", 1, genre, year);
        Book book4 = new Book(98578, "Life in AI", "Karl Borg", 1, genre, year);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "Life in cs", year, genre);
        //actual = libr2.searchByTitle("Life in cs");
        
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(!actual.get(i).getTitle().toLowerCase().contains("life in cs")){
                flag = false;
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Title1() {//returning a list of books having a that title in their name
        ArrayList<Book> actual = new ArrayList<Book>();
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, year);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, year);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "Life in cs", year, genre);
        //actual = libr2.searchByTitle("Life in cs");
        
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(!actual.get(i).getTitle().toLowerCase().contains("life in ai")){
                flag = false;
            }
        }
        assertEquals(true, flag);//due to the ! on the if statement
    }
    
    @Test
    public void search_Year() {//returning a list of books having a the same Publish Year
        ArrayList<Book> actual;
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, 2015);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, 2015);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, 2016);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, 2016);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        actual = libr2.searchByYearOfPublication(2015);
        
        //libr2.search(2015);

        
        
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(actual.get(i).getYrOfPub() != 2015){
                flag = false;
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Year1() {//returning a list of books having a the same Publish Year
        ArrayList<Book> actual;
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, 2000);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, 1996);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        actual = libr2.searchByYearOfPublication(2015);
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(actual.get(i).getYrOfPub() != 2020){
                flag = false;
            }
        }
        assertEquals(false, flag);
    }
    
    @Test
    public void get_AllBooks() {//returning a list of all books
        ArrayList<Book> all = new ArrayList<Book>();
        ArrayList<Book> expected;
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, 2000);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, 1996);
        
        all.add(book1);
        all.add(book2);
        all.add(book3);
        all.add(book4);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        expected = libr2.getAllBook();
        boolean flag = false;
        if(expected.size() == all.size()){
            flag = true;
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Genre() {//returning a list of books having a the same Genre
        ArrayList<Book> actual;
        
        Library libr2 = new Library();
        Genre genre1 = new Genre("Comedy");
        Genre genre2 = new Genre("Satire");
        Genre genre3 = new Genre("Biography");
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre1, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre1, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre2, year);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre3, year);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        actual = libr2.searchByGenre(genre1);
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(actual.get(i).getGenre().getGenre() != genre1.getGenre()){
                flag = false;
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Genre1() {//returning a list of books having a the same Genre
        ArrayList<Book> actual;
        
        Library libr2 = new Library();
        Genre genre1 = new Genre("Comedy");
        Genre genre2 = new Genre("Satire");
        Genre genre3 = new Genre("Biography");
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre1, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre1, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre2, 2000);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre3, 1996);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        actual = libr2.searchByGenre(genre1);
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(actual.get(i).getGenre().getGenre() != genre2.getGenre()){
                flag = false;
            }
        }
        assertEquals(false, flag);
    }
    
    @Test
    public void retrun_Book() {//returning a book that was loaned out
        Book book1 = new Book(6854, "Life in CS", "Karl Borg", 1, genre, year);
        libr.Book(1, book1);
        libr.loanTo(book1,user,SimpleDateFormat);
        assertEquals(true,libr.returnBook(book1));
    }
    
    @Test
    public void retrun_Book1() {//returning a book that was not loaned out
        Book book1 = new Book(6854, "Life in CS", "Karl Borg", 1, genre, year);
        libr.Book(1, book1);
        assertEquals(false,libr.returnBook(book1));
    }
    
}
