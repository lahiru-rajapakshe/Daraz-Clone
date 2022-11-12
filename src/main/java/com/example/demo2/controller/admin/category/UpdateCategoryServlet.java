package com.example.demo2.controller.admin.category;

import com.example.demo2.controller.admin.BaseServlet;
import com.example.demo2.service.CategoryServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/update_category", value = "/UpdateCategoryServlet")
public class UpdateCategoryServlet extends BaseServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
        categoryServices.updateCategory();
    }
}
