package com.example.demo2.controller.admin.book;

import com.example.demo2.service.BookServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/update_book", value = "/UpdateBookServlet")
@MultipartConfig(fileSizeThreshold = 1024*10,maxFileSize = 1024*300,maxRequestSize = 1024*1024)

public class UpdateBookServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServices bookServices = new BookServices( request, response);
        bookServices.updateBook();
    }
}
