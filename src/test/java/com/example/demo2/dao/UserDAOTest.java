package com.example.demo2.dao;

import com.example.demo2.entity.UsersEntity;
import com.example.demo2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.Serializable;

import static org.junit.Assert.*;

public class UserDAOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @BeforeAll
    public static void before() {
        System.out.println("starting test ");
    }

    @AfterAll
    public static void after() {
        System.out.println("testing is over");
    }

    @Test
    void create() {
//        UsersEntity usersEntity = new UsersEntity();
//        usersEntity.setEmail("lara@gmail.com");
//        usersEntity.setPassword("1234");
//        usersEntity.setFullName("lara");
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        UserDAO userDAO = new UserDAO(entityManager);
//        usersEntity = userDAO.create(usersEntity);
//
//
//
//        entityManager.close();
//        entityManagerFactory.close();
//
//        assertTrue(usersEntity.getUserId()>0 );

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            UsersEntity usersEntity = new UsersEntity(99, "lara@gmail.com", "1111", "lara");
            Serializable save = session.save(usersEntity);

            assertTrue(usersEntity.getUserId() > 1);
            session.beginTransaction().commit();
        } catch (Throwable t) {
            if (session != null & session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
