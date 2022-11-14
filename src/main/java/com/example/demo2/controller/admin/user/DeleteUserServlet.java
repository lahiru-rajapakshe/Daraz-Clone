package com.example.demo2.controller.admin.user;

import com.example.demo2.controller.BaseServlet;
import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/delete_user", value = "/DeleteUserServlet")
public class DeleteUserServlet extends BaseServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices(entityManager,request, response);
        userServices.deleteUser();
    }

}
