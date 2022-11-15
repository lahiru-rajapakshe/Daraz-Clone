package com.example.demo2.dao;

import com.example.demo2.entity.Book;
import com.example.demo2.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest extends BaseDAOTest {
private static  BookDAO bookDAO;

    public BookDAOTest(EntityManager entityManager) {
        super(entityManager);

    }



@BeforeClass
public static  void setupBefore() throws Exception {
    BaseDAOTest.setupBeforeClass();
    new BookDAO(entityManager);
}

@AfterClass
public static void tearDownAfterClass(){
//BaseDAOTest.tearDownAfterClass();
}
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void get() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void listAll() {
    }

    @Test
    void count() {
    }

    @Test
    public void testCreate() throws ParseException {
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

        newBook.setPublishDate((java.sql.Date) publishDate);
        Book createdBook = bookDAO.create(newBook);

        assertTrue(createdBook.getBookId()>0);



    }
}