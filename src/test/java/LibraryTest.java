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
    SimpleDateFormat dateFormat = new SimpleDateFormat("28-FE-2015");
        
    
    @Before
    public void Library() {
        libr = new Library();
        user = new User("Test Name", "Test surname",1);
        
        book = new Book(123, "Life in CS", "Karl Borg", 1, genre, dateFormat);
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
    public void add_Book() {//adding a new user with different id
        assertEquals(true,cat.newBookInfo(1, "Life in CS", "Karl Borg", 1, genre, dateFormat));
    }

    @Test
    public void add_Book_1() {//user already exists since id already exists
        Book book1 = new Book(123, "Life in CS", "Karl Borg", 1, genre, dateFormat);
        assertEquals(false,cat.newBookInfo(123, "Life in CS", "Karl Borg", 1, genre, dateFormat));
    }
    
}
