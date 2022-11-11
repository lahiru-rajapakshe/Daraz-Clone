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


        UserServices userServices = new UserServices(request,response);
        userServices.createuser();
userServices.listUser("New User Created !");



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
