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

class CategoryDAOTest  {
    private static EntityManagerFactory entityManagerFactory;
    private static  EntityManager entityManager;
private static CategoryDAO categoryDAO;

@BeforeClass
public static  void setupBeforeClass() throws Exception{
    entityManagerFactory= Persistence.createEntityManagerFactory("BookStoreWebsite");
    entityManager=entityManagerFactory.createEntityManager();
    categoryDAO=new CategoryDAO(entityManager);
}
    @BeforeEach
    void setUp() {

    }

    @AfterClass
    void tearDown() throws Exception{
    entityManager.close();
    entityManagerFactory.close();
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