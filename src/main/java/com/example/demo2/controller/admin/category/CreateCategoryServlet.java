package com.example.demo2.controller.admin.category;

import com.example.demo2.controller.BaseServlet;
import com.example.demo2.service.CategoryServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/create_category", value = "/CreateCategoryServlet")
public class CreateCategoryServlet extends BaseServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
        categoryServices.createCategory();
    }
}
