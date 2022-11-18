package com.example.demo2.controller.frontend;

import com.example.demo2.service.BookServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/view_category", value = "/ViewBooksByCategoryServlet")
public class ViewBooksByCategoryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServices bookServices = new BookServices(entityManager, request, response);
        bookServices.listBooksByCcategory();
    }


}
