package com.example.demo2.controller.admin.customer;

import com.example.demo2.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/edit_customer", value = "/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.editCustomers();
    }
}
