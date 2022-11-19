package com.example.demo2.service;

import com.example.demo2.dao.CustomerDAO;
import com.example.demo2.entity.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CustomerServices {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
    }

    public void listCustomers() throws ServletException, IOException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> listCustomer = customerDAO.listAll();

        request.setAttribute("listCustomer",listCustomer);
        String listPage="custtomer_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request,response);



    }
}
