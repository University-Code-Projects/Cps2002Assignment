/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import com.mycompany.assignmnet.Library;
import com.mycompany.assignmnet.User;
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
    
    @Before
    public void Calculator() {
        libr = new Library();
        user = new User("Test Name", "Test surname",1);
        libr.addUser(user);
    }
    
    @After
    public void Calculator1() {
        libr = null;
    }
    
    @Test
    public void is_Valid_User() {
        int id = 1;
        assertEquals(true,libr.validUser(user));
    }
    
}
