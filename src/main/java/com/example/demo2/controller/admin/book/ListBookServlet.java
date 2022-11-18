package com.example.demo2.controller.admin.book;

import com.example.demo2.controller.BaseServlet;
import com.example.demo2.service.BookServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/list_books", value = "/ListBookServlet")
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServices bookServices = new BookServices( request, response);
        bookServices.listBooks();
    }

}
