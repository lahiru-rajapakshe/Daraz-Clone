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
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();

        userDAO = new UserDAO(entityManager);

    }

    public void listUser() throws ServletException, IOException {

        listUser(null);

    }

    public void listUser(String message) throws ServletException, IOException {

        List<Users> listUsers = userDAO.listAll();

        request.setAttribute("list_users ", listUsers);

        if (message != null) {
            request.setAttribute("message", message);

        }
        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);


    }

    public void createuser() throws ServletException, IOException {

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users existuser = userDAO.findByEmail(email);
        if (existuser != null) {
            String message = " Couldn't create the user " + email + " already exists !";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);


        } else {
            Users newUsers = new Users(email, fullName, password);
            userDAO.create(newUsers);
            listUser("New User Created !");
        }


    }

    public void editUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        Users user = userDAO.get(userId);

        String editPage = "user_form.jsp";
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request, response);


    }

    public void updateUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");

        Users userById = userDAO.get(userId);
        Users userByEmail = userDAO.findByEmail(email);

        if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
            String message = "Could not update the user, "+email+" already exists !";
                request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);


        } else {
            Users users = new Users(userId, email, fullName, password);
            userDAO.update(users);

            String message = "User has been updated succesfully";
            listUser(message);


        }



    }

    public void deleteUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("Id"));
        userDAO.delete(userId);
        String message = "User has been deleted succesfully";
        listUser(message);
    }
}
