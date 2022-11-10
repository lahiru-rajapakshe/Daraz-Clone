package com.example.demo2.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String homepage= "indexc.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        System.out.println("Admin home");
        dispatcher.forward(request,response);
    }


}
