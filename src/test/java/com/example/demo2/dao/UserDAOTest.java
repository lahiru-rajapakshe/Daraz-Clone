package com.example.demo2.dao;

import com.example.demo2.entity.Users;
import com.example.demo2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.Serializable;

import static org.junit.Assert.*;

public class UserDAOTest extends JpaDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();


    public UserDAOTest(EntityManager entityManager) {
        super(entityManager);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @AfterClass
    static void g() {


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


        try {
            Users users = new Users(82, "re", "26", "UAE");


            session.save(users);
            System.out.println(users);

            session.getTransaction().commit();

            assertTrue(users.getUserId() > 1);
        } catch (Throwable t) {
            if (session != null & session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Test
    void update() {

        try {
            Users users = new Users(10, "dilskup", "26", "UAE");

            System.out.println(users);
//            users=UserDAO.update(users);


        } catch (Throwable t) {
            if (session != null & session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
   public  void get() {
        Integer userId = 1;
        Users user = UserDAO.get(userId);
        if(user != null){
            System.out.println(user.getEmail()); // checking the nullable or not
        }
        assertNotNull(user);

    }

    @Test
    public static void testGetUsersNotFound(){
        Integer userId=99;
        Users users = UserDAO.get(userId);

        if(users == null){
            System.out.println("user is is null");
        }

        assertNull(users);
    }


    @Test
    void testDelete() {
        Integer userId= 5;
        UserDAO.delete(userId);


    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteNonExistusers(){
        Integer userId=55;
        userDAO.delete(userId);

    }
}
