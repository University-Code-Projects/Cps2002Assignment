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
    User user = new User("Test Name", "Test surname",1);
    Catalogue cat = new Catalogue();
    Book book = new Book();
    Genre genre = new Genre();
    SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("02/28/2012 12:00:00");
    int year = 2015;
   
    @Before
    public void Library() {
        libr = new Library();
        user = new User("Test Name", "Test surname",1);
        book = new Book(123, "Life in CS", "Karl Borg", 1, genre, year);
        libr.addUser(user);
        cat.addBook(book);
    }
    
    @After
    public void Libray1() {
        libr = null;
        cat = null;
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
        System.out.println("loan_To2 entry");
            
        User user1 = new User("Test Name", "Test surname",96541);
        Book book1 = new Book(6854, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(1232559, "Life in CS", "Karl Borg", 1, genre, year);
        Book book3 = new Book(17412568, "Life in CS", "Karl Borg", 1, genre, year);
        
        libr.Book(1, book1);
        libr.Book(1, book2);
        libr.Book(1, book3);

        System.out.println("loaning book2");
        libr.loanTo(book2, user, SimpleDateFormat);
        System.out.println("loaning book3");
        libr.loanTo(book3, user, SimpleDateFormat);
        System.out.println("return book3");
        libr.loanTo(book, user, SimpleDateFormat);
        assertEquals(false,libr.loanTo(libr.getBook(book1.getIsbn()) , user, SimpleDateFormat));
    }
    
    @Test
    public void retrun_Book() {//returning a book that was loaned out
        Book book1 = new Book(6854, "Life in CS", "Karl Borg", 1, genre, year);
        libr.Book(1, book1);
        libr.loanTo(book1,user,SimpleDateFormat);
        assertEquals(true,libr.returnBook(book1));
    }

    @Test
    public void retrun_Book1() {//returning a book that was loaned out
        Book book1= new Book();
        assertEquals(false,libr.returnBook(book1));
    }

    @Test
    public void search_Title() {//returning a list of books having a that title in their name
        ArrayList<Book> expected = new ArrayList<Book>();
        ArrayList<Book> actual = new ArrayList<Book>();
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life in CS", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Life in CS", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "Life in CS", "Karl Borg", 1, genre, year);
        Book book4 = new Book(98578, "Life in AI", "Karl Borg", 1, genre, year);

        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);   
        libr2.Book(1, book4);   

        actual = libr2.searchByTitle("Life in cs");
        
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
        ArrayList<Book> expected = new ArrayList<Book>();
        ArrayList<Book> actual = new ArrayList<Book>();
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, year);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, year);

        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);   
        libr2.Book(1, book4);   

        actual = libr2.searchByTitle("Life in cs");
        boolean flag = true;
        for(int i=0; i < actual.size(); i++){
            if(!actual.get(i).getTitle().toLowerCase().contains("life in ai")){
                flag = false;
            }
        }
        assertEquals(true, flag);
    }
    
}
