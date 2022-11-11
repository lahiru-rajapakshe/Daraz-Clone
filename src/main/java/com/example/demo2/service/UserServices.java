package com.example.demo2.service;

import com.example.demo2.dao.UserDAO;
import com.example.demo2.entity.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
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

    public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> listUsers = userDAO.listAll();

        request.setAttribute("list_users ", listUsers);
        String listPage= "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request,response);



        


    }
    public void createuser(HttpServletRequest request, HttpServletResponse response){

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users newUsers = new Users(email,fullName,password);
        userDAO.create(newUsers);





    }
}
