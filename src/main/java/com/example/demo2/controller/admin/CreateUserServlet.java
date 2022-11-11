package com.example.demo2.controller.admin;

import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/create_user", urlPatterns = {"/admin/create_user"})
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        response.getWriter().println("Email "+ email);
        response.getWriter().println("fullName "+ fullName);
        response.getWriter().println("password "+ password);

        UserServices userServices = new UserServices();
        userServices.createuser(email,fullName,password);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
