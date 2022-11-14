package com.example.demo2.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "BaseServlet", value = "/BaseServlet")
public abstract class BaseServlet extends HttpServlet {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;



    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();

    }
    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }



}
