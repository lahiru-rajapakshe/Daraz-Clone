package com.example.demo2.controller.admin;

import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/login", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices( request, response);
//        response.getWriter().println(email+ " "+ password);
userServices.login();

    }
}
