package com.example.demo2.controller.admin.customer;

import com.example.demo2.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/create_customer", value = "/CreateCustomerServlet")
public class CreateCustomerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.createCustomer();
    }
}
