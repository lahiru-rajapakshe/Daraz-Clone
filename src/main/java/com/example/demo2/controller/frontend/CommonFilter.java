package com.example.demo2.controller.frontend;

import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.entity.Category;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "/*")
public class CommonFilter implements Filter {
    private final CategoryDAO categoryDAO;

    public CommonFilter() {
        categoryDAO=new CategoryDAO();
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        String path= httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
if(path.startsWith("/admin/")){

    List<Category> listCategories = categoryDAO.listAll();
    request.setAttribute("listCategories",listCategories);
    System.out.println("common filter "+path);
}



        chain.doFilter(request, response);


    }
}
