package com.example.demo2.controller.admin.category;

import com.example.demo2.controller.admin.BaseServlet;
import com.example.demo2.service.CategoryServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/delete_category", value = "/DeleteCategoryServlet")
public class DeleteCategoryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryServices categoryServices = new CategoryServices(entityManager, req, response);
        categoryServices.deleteCategory();
    }

}
