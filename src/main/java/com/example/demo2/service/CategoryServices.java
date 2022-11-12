package com.example.demo2.service;

import com.example.demo2.dao.CategoryDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryServices {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    //Generic constructor
    public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();

        categoryDAO = new CategoryDAO(entityManager);

    }
public void listCategory(){

}

}
