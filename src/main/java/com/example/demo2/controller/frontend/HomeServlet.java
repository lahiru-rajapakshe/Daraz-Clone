package com.example.demo2.controller.frontend;

import com.example.demo2.dao.BookDAO;
import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.entity.Book;
import com.example.demo2.entity.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO(entityManager);
        List<Category> listCategories = categoryDAO.listAll();
        request.setAttribute("listCategories",listCategories);
        BookDAO bookDAO = new BookDAO(entityManager);
//        categoryDAO.listAll();
        List<Book> listNewBooks = bookDAO.listNewBooks();

        request.setAttribute("listNewBooks",listNewBooks);



        String homepage= "frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        dispatcher.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
