package com.example.demo2.service;

import com.example.demo2.dao.BookDAO;
import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.entity.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public class BookServices {
  private EntityManager entityManager;
  private HttpServletRequest request;
  private HttpServletResponse response;
  private CategoryDAO categoryDAO;
  private BookDAO bookDAO;


    public BookServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

        this.entityManager = entityManager;
        this.request = request;
        this.response = response;

        bookDAO = new BookDAO(entityManager);
        categoryDAO = new CategoryDAO(entityManager);
    }

    public void listBooks() throws ServletException, IOException {
        List<BookDAO> listBooks =bookDAO.listAll();
        request.setAttribute("listBooks",listBooks);

        String listPage="book_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request,response);



    }

    public void showBookNewForm() throws ServletException, IOException {
        List<Category> listCategories =categoryDAO.listAll();
        request.setAttribute("listCategories",listCategories);

        String newPage="book_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
        requestDispatcher.forward(request,response);



    }
}
