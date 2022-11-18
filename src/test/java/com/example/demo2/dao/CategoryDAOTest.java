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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest extends JpaDAO {

    private static CategoryDAO categoryDAO;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
      categoryDAO.close();
    }

    @BeforeEach
    void setUp() {

    }

    @AfterClass
    public static void tearDown() throws Exception {
        BaseDAOTest.tearDown();
    }

    @Test
    void testCreateCategory() {
        Category javas = new Category("Javas");
        Category category = categoryDAO.create(javas);

        assertTrue(category != null && category.getCategoryId() > 0);


    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category("Java core");
        category.setCategoryId(1);
        Category update = categoryDAO.update(category);

        assertEquals(category.getName(), update.getName());


    }


    @Test
    public void testGet() {
        Integer catId = 2;
        Category category = categoryDAO.get(catId);
        assertNotNull(category);


    }

    @Test
    public void testDeleteCategory() {
        Integer catId = 3;
        categoryDAO.delete(catId);

        Category category = categoryDAO.get(catId);
        assertNull(category);


    }

    @Test
    public void listAll() {
        List<Category> categories = categoryDAO.listAll();

        assertTrue(categories.size() > 0);
        categories.forEach(c -> System.out.println(c.getName() + " ,"));

    }

    @Test
public void count() {
        long count = categoryDAO.count();
        assertEquals(4,count);




    }

    @Test
    public void findByName() {
        String name="Java core";
        Category byName = categoryDAO.findByName(name);
        assertNotNull(byName);


    }

    @Test
    public void findByNameNotFound() {
        String name="Java core 2";
        Category byName = categoryDAO.findByName(name);
        assertNull(byName);



    }
}