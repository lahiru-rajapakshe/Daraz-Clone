package com.example.demo2.controller.frontend.customer;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/logout", value = "/CustomerLogoutServlet")
public class CustomerLogoutServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getSession().removeAttribute("loggedCustomer");
    response.sendRedirect(request.getContextPath());
    }

}
