package com.example.demo2.controller.admin.user;

import com.example.demo2.controller.admin.BaseServlet;
import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/create_user", urlPatterns = {"/admin/create_user"})
public class CreateUserServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UserServices userServices = new UserServices(entityManager,request,response);
        userServices.createuser();




    }


}
