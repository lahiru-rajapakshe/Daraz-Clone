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
    CustomerDAO customerDAO ;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
        this.customerDAO = new CustomerDAO();
    }

    public void listCustomers( String message ) throws ServletException, IOException {

        if(message!= null){
            request.setAttribute("message", message);

        }
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> listCustomer = customerDAO.listAll();

        request.setAttribute("listCustomer",listCustomer);
        String listPage="custtomer_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request,response);



    }
    public void listCustomers( ) throws ServletException, IOException {
        listCustomers(null);





    }

    public void createCustomer() throws ServletException, IOException {
        String email = request.getParameter("email");
        Customer byEmail =customerDAO.findByEmail(email);
        if(byEmail != null){
            String message= " could not create a new  customer "+email +" has resgisterded a another user ";
listCustomers(message);
        }else{
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String phone = request.getParameter("phonee");

            // you need to get these items from the db

            Customer newCustomer = new Customer();

            newCustomer.setPassword(password);
            newCustomer.setFullName(fullName);
            newCustomer.setPhone(phone);

            customerDAO.create(newCustomer);

        }


    }
}
