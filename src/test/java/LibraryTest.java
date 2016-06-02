/**
 * Unit Test Class
 * @author Jonathan Borg and Karl Farrugia
 */

import com.mycompany.assignmnet.Library;
import com.mycompany.assignmnet.User;
import com.mycompany.assignmnet.Book;
import com.mycompany.assignmnet.Genre;
import com.mycompany.assignmnet.*;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    
    public LibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    //generic objects created to be used during different unit tests
    Library libr = new Library();
    Library libr2 = new Library();
    User user = new User("Test Name", "Test surname",1);
    User user2 = new User("Test Name", "Test surname",8956);
    Catalogue cat = new Catalogue();
    Book book = new Book();
    Genre genre = new Genre("Horror");
    Genre genre01 = new Genre("Comedy");
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
    
    //testing of setter and getting in User Class
    @Test
    public void set_Name() {
        user.setName("First Client Name");
        boolean flag = false;
        if(user.getName() == "First Client Name"){
            flag = true;
        }
        user.setName("Test Name");
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Surame() {
        user.setSurname("First Client Surname");
        boolean flag = false;
        if(user.getSurname() == "First Client Surname"){
            flag = true;
        }
        user.setSurname("Test surname");
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Id() {
        user.setId(159);
        boolean flag = false;
        if(user.getId() == 159){
            flag = true;
        }
        user.setId(1);
        assertEquals(true,flag);
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
    
     //testing of setter and getting Book Class    
    @Test
    public void set_Author() {
        book.setAuthor("Jonathan Farrugia");
        boolean flag = false;
        if(book.getAuthor() == "Jonathan Farrugia"){
            flag = true;
        }
        book.setAuthor("Karl Borg");
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Edition() {
        book.setEdition(2);
        boolean flag = false;
        if(book.getEdition() == 2){
            flag = true;
        }
        book.setEdition(1);
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Genre() {
        book.setGenre(genre01);
        boolean flag = false;
        if(book.getGenre() == genre01){
            flag = true;
        }
        book.setGenre(genre);
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Isbn() {
        book.setIsbn(456);
        boolean flag = false;
        if(book.getIsbn() == 456){
            flag = true;
        }
        book.setIsbn(123);
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Title() {
        book.setTitle("Life in UoM");
        boolean flag = false;
        if(book.getTitle() == "Life in UoM"){
            flag = true;
        }
        book.setTitle("Life in CS");
        assertEquals(true,flag);
    }
    
    @Test
    public void set_Year() {
        book.setYrOfPub(2016);
        boolean flag = false;
        if(book.getYrOfPub() == 2016){
            flag = true;
        }
        book.setYrOfPub(year);
        assertEquals(true,flag);
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
    public void search_Title() {//returning a list of books having the same title as being checked, expected to succeed as title checked is title of one of the books
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
        
        boolean flag = true;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(!actual.get(i).getTitle().toLowerCase().contains("life in cs")){
                    flag = false;
                }
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Title1() {//returning a list of books having the same title as being checked, expected to fail as title checked is not a title of one of the books
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
        
        boolean flag = true;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(!actual.get(i).getTitle().toLowerCase().contains("life in ai")){
                    flag = false;
                }
            }
        }
        assertEquals(false, flag);
    }

    @Test
    public void search_Year() {//returning a list of books having the same Publish Year as being checked, expected to succeed as Publish Year checked is Publish Year of one of the books
        ArrayList<Book> actual = new ArrayList<Book>();
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, 2015);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, 2015);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, 2016);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, 2016);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "", 2015, genre);
        
        boolean flag = true;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(actual.get(i).getYrOfPub() != 2015){
                    flag = false;
                }
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Year1() {//returning a list of books having the same Publish Year as being checked, expected to fail as Publish Year checked is not Publish Year of one of the books
        ArrayList<Book> actual = new ArrayList<Book>();
        
        Library libr2 = new Library();
        
        Book book1 = new Book(86551, "Life as seen by SD", "Karl Borg", 1, genre, year);
        Book book2 = new Book(74866, "Fun", "Karl Borg", 1, genre, year);
        Book book3 = new Book(98568, "SunFlowers", "Karl Borg", 1, genre, 2000);
        Book book4 = new Book(98578, "Rainbows", "Karl Borg", 1, genre, 1996);
        
        libr2.Book(1, book1);
        libr2.Book(1, book2);
        libr2.Book(1, book3);
        libr2.Book(1, book4);
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "", 2015, genre);

        boolean flag = true;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(actual.get(i).getYrOfPub() != 2020){
                    flag = false;
                }
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
        ArrayList<Book> actual = new ArrayList<Book>();
        
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
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "", 0, genre1);
        
        boolean flag = true;
        if(actual.size() == 0){
            flag = false;
        }else{    
            for(int i=0; i < actual.size(); i++){
                if(actual.get(i).getGenre().getGenre() != genre1.getGenre()){
                    flag = false;
                }
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Genre1() {//returning a list of books having a the same Genre
        ArrayList<Book> actual = new ArrayList<Book>();
        
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
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "", 0, genre1);
        
        boolean flag = true;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(actual.get(i).getGenre().getGenre() != genre2.getGenre()){
                    flag = false;
                }
            }
        }
        assertEquals(false, flag);
    }
    
    @Test
    public void search_Books() {//searching for a book by title, expected to succeed as title checked is one of the titles given (task 2 of assignment past 2)
        ArrayList<Book> actual = new ArrayList<Book>();
        
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
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "Fun", year, genre1);
        //actual = libr2.searchByGenre(genre1);
        
        boolean flag = false;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(actual.get(i).getGenre() == genre1){
                    if(actual.get(i).getYrOfPub() == year){
                        if(actual.get(i).getTitle() == "Fun"){
                            flag = true;
                        }
                    }
                }          
            }
        }
        assertEquals(true, flag);
    }
    
    @Test
    public void search_Books_1() {//searching for a book by title, expected to fail as title checked is not one of the titles given (task 2 of assignment past 2)
        ArrayList<Book> actual = new ArrayList<Book>();
        
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
        
        actual = libr2.searchForBooks(libr2.getAllBook(), actual, "Fun", year, genre1);
        //actual = libr2.searchByGenre(genre1);
        
        boolean flag = false;
        if(actual.size() == 0){
            flag = false;
        }else{
            for(int i=0; i < actual.size(); i++){
                if(actual.get(i).getGenre() == genre){
                    if(actual.get(i).getYrOfPub() == 1999){
                        if(actual.get(i).getTitle() == "Testing For Failures"){
                            flag = true;
                        }
                    }
                }          
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
    
    @Test
    public void observer_Test() {//checking the user in the waiting list for the book, expected to succeed as user is on the waiting list (task 3 of assignment past 2)
        Book book10 = new Book(99999, "Testing for observer", "Karl Borg", 1, genre, year);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        
        cat.addBook(book10);
        
        Library libr10 = new Library(users,cat);
        
        libr10.loanTo(book10, user, SimpleDateFormat);
        libr10.loanTo(book10, user2, SimpleDateFormat);
        ArrayList<User> waitingNoUsers = book10.getWantingBook();
        
        boolean flag = false;
        if(waitingNoUsers.size() == 1){
            if(waitingNoUsers.get(0).getId() == 8956){
                flag = true;
            }
        }
        assertEquals(true,flag);
    }
    
    @Test
    public void observer_Test_1(){//checking the user in the waiting list for the book, expected to succeed as there are no users in the waiting list (task 3 of assignment past 2)       
        Book book10 = new Book(99999, "Life in CS", "Karl Borg", 1, genre, year);
        
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        
        cat.addBook(book10);
        Library libr10 = new Library(users,cat);

        libr10.loanTo(book10, user, SimpleDateFormat);
        libr10.loanTo(book10, user2, SimpleDateFormat);

        libr10.returnBook(book10);
        ArrayList<User> waitingNoUsers = book10.getWantingBook();
        
        boolean flag = false;
        if(waitingNoUsers.size() == 0){
            flag = true;
        }
        assertEquals(true,flag);
    }
}
