package com.example.demo2.controller.admin.user;

import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/edit_user", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices(request, response);
        userServices.editUser();

    }


}
