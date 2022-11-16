package com.example.demo2.controller.admin.book;

import com.example.demo2.controller.BaseServlet;
import com.example.demo2.service.BookServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/create_book", value = "/CreateBookServlet")
@MultipartConfig(fileSizeThreshold = 1024*10,maxFileSize = 1024*300,maxRequestSize = 1024*1024)
public class CreateBookServlet extends BaseServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServices bookServices = new BookServices(entityManager,request,response);
        bookServices.createBook();


    }
}
