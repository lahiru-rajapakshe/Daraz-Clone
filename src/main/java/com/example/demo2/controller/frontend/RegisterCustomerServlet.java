package com.example.demo2.controller.frontend;

import com.example.demo2.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterCustomerServlet", value = "/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.registerCustomer();
    }
}
