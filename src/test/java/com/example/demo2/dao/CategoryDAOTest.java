package com.example.demo2.dao;

import com.example.demo2.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest extends BaseDAOTest {

private static CategoryDAO categoryDAO;

@BeforeClass
public static  void setupBeforeClass() throws Exception{
    BaseDAOTest.setupBeforeClass();
    categoryDAO=new CategoryDAO(entityManager);
}
    @BeforeEach
    void setUp() {

    }

    @AfterClass
    public static void tearDown() throws Exception{
    BaseDAOTest.tearDown();
    }

    @Test
    void testCreateCategory() {
        Category javas = new Category("Javas");
        Category category = categoryDAO.create(javas);

        assertTrue(category != null && category.getCategoryId()>0);



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
}