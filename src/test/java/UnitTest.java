/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.assignmnet.Book;
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
public class UnitTest {
    
    /**
     *
     */
    public UnitTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    Book book = new Book();    
    
    /**
     *
     */
    @Before
    public void Book() {
        book = new Book();
        
    }
    
    /**
     *
     */
    @After
    public void Book1() {
        book = null;
    }

    /**
     *
     */
    @Test
    public void title_return_0(){
        book.setTitle("Life");
        assertEquals("Life" , book.getTitle());
    
    }
    
    //@Test
    //public void title_return_1(){
    //    book.setTitle("Fail");
    //    assertEquals("Life" , book.getTitle());
    
    //}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
