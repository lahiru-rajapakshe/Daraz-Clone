package com.example.demo2.dao;

import com.example.demo2.entity.Book;
import com.example.demo2.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest extends JpaDAO {
    private static BookDAO bookDAO;

    public BookDAOTest(EntityManager entityManager) {
        super(entityManager);

    }


    @BeforeClass
    public static void setupBefore() throws Exception {
        BaseDAOTest.setupBeforeClass();
        new BookDAO(entityManager);
    }

    @AfterClass
    public static void tearDownAfterClass() {
//BaseDAOTest.tearDownAfterClass();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

//    @Test(expected = EntityNotFoundException.class)
    public void testGetBookFail() {
        Integer bookId = 99;
        Book book = bookDAO.get(bookId);
        assertNull(book);
    }
//    @Test(expected = EntityNotFoundException.class)
    @Test

    public void testGetBookSuccess() {
        Integer bookId = 99;
        Book book = bookDAO.get(bookId);
        assertNotNull(book);


    }
    @Test
    void testDelete() {
    }

    @Test
    public void listAll() {
        List<BookDAO> bookDAOS = bookDAO.listAll();
        assertFalse(bookDAOS.isEmpty());

    }

    @Test
    void count() {
    }

    @Test
    public void testCreate() throws ParseException, IOException {
        Book newBook = new Book();

        Category advanced_java = new Category("Advanced java");
        advanced_java.setCategoryId(2);

        newBook.setCategoryByCategoryId(advanced_java);

        newBook.setTitle("Effective java ");
        newBook.setAuthor("Joseph");
        newBook.setDescription("some description");
        newBook.setPrice(222.4);
        newBook.setIsbn("1134234123");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = simpleDateFormat.parse("22,2,2022");

        String imagePath = "";
//        put ur image path here
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        newBook.setImage(imageBytes);


        newBook.setPublishDate((java.sql.Date) publishDate);
        Book createdBook = bookDAO.create(newBook);

        assertTrue(createdBook.getBookId() > 0);


    }

    @Test
    public void testUpdateBook() throws IOException, ParseException {
        Book existBook = new Book();
        existBook.setBook(String.valueOf(1));

        Category advanced_java = new Category("changed Advanced java");
        advanced_java.setCategoryId(2);

        existBook.setCategoryByCategoryId(advanced_java);

        existBook.setTitle("changed Effective java ");
        existBook.setAuthor("changed Joseph");
        existBook.setDescription("changed  some description");
        existBook.setPrice(22.4);
        existBook.setIsbn("77971134234123");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = simpleDateFormat.parse("22,2,2022");

        String imagePath = "";
//        put ur image path here
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        existBook.setImage(imageBytes);


        existBook.setPublishDate((java.sql.Date) publishDate);
        Book updatedBook = bookDAO.update(existBook);

        assertTrue(updatedBook.getTitle(), "changed Effective java ");


    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteBookFail() {
        Integer bookId = 100;
        bookDAO.delete(bookId);
//        assertTrue(true);


    }

    @Test
    public void testDeleteBookSuccess() {
        Integer bookId = 100;
        bookDAO.delete(bookId);
        assertTrue(true);


    }

    @Test
    public void testFindByTitleNotExist(){
        String title="thinking in java";
        Book book = bookDAO.findByTitle(title);
        System.out.println(book.getPrice());
        System.out.println(book.getAuthor());
        assertNull(book);

    }

    @Test
    public void testFindByTitleExist(){
        String title="thinking in java 2";
        Book book = bookDAO.findByTitle(title);
        assertNotNull(book);

    }

    @Test
    public void testCount() {
        long count = bookDAO.count();
        assertEquals(2,count);

    }

    @Test
    public void search() {
String keyword="Java";
        List<Book> search = bookDAO.search(keyword);
        assertEquals(7,search.size());
    }
}