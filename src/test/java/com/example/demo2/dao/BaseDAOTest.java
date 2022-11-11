package com.example.demo2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    public static  void setupBeforeClass() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void tearDown() throws Exception{
        entityManager.close();
        entityManagerFactory.close();
    }
}
