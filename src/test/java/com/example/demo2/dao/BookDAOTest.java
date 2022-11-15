package com.example.demo2.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest extends BaseDAOTest {

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
    void testCreate() {
    }
}