package com.example.demo2.controller.admin;

import com.example.demo2.entity.Users;
import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "/admin/list_users", value = "/ListUsersServlet")
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserServices userServices = new UserServices();
        List<Users> listUsers = userServices.listUser();
        request.setAttribute("listUsers",listUsers);
        

        String listPage="user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request,response);

    }


}
