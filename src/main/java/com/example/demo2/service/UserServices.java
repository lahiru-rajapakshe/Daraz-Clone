package com.example.demo2.service;

import com.example.demo2.dao.UserDAO;
import com.example.demo2.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserServices {
    private UserDAO userDAO;
    private SessionFactory sessionFactory;
    private Session session;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UserServices() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();

        userDAO = new UserDAO(entityManager);

    }

    public List<Users> listUser() {
        List<Users> listUsers = userDAO.listAll();
        return listUsers;
        


    }
    public void createuser(String  email, String fullname, String password){
        Users newUsers = new Users(email,fullname,password);
        userDAO.create(newUsers);





    }
}
