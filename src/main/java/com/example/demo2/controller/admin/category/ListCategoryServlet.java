package com.example.demo2.controller.admin.category;

import com.example.demo2.controller.BaseServlet;
import com.example.demo2.service.CategoryServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/list_category", value = "/ListCategoryServlet")
public class ListCategoryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("List category");
        CategoryServices categoryServices = new CategoryServices(entityManager,request, response);
        categoryServices.listCategory();
    }


}
