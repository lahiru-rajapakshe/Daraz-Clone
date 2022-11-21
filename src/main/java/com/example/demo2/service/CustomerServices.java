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
    CustomerDAO customerDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
        this.customerDAO = new CustomerDAO();
    }

    public void listCustomers(String message) throws ServletException, IOException {

        if (message != null) {
            request.setAttribute("message", message);

        }
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> listCustomer = customerDAO.listAll();

        request.setAttribute("listCustomer", listCustomer);
        String listPage = "custtomer_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);


    }

    public void listCustomers() throws ServletException, IOException {
        listCustomers(null);


    }

    public void createCustomer() throws ServletException, IOException {
        String email = request.getParameter("email");
        Customer byEmail = customerDAO.findByEmail(email);
        if (byEmail != null) {
            String message = " could not create a new  customer " + email + " has resgisterded a another user ";
            listCustomers(message);
        } else {
            Customer newCustomer = new Customer();

            updateCustomerFields(newCustomer);
            customerDAO.create(newCustomer);

            String message = "new customer has been registered successfuly !";
            listCustomers(message);

        }


    }

    String message = "";

    public void registerCustomer() throws ServletException, IOException {
        String email = request.getParameter("email");
        Customer byEmail = customerDAO.findByEmail(email);
        if (byEmail != null) {
            String message = " could not register a new  customer " + email + " has resgisterded a another user ";
            listCustomers(message);
        } else {
            Customer updatedCustomer = new Customer();

            updateCustomerFields(updatedCustomer);
            customerDAO.create(updatedCustomer);

            message = "new customer has been registered successfuly !";


        }
        String messagePage = "message.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
        request.setAttribute("message", message);
        requestDispatcher.forward(request, response);

    }
    private void updateCustomerFields(Customer customer){
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phonee");

        // you need to get these items from the db

        Customer newCustomer = new Customer();

        newCustomer.setPassword(password);
        newCustomer.setFullName(fullName);
        newCustomer.setPhone(phone);

    }

    public void editCustomers() throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.get(customerId);

        request.setAttribute("customer", customer);
        String editPage = "customer_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request, response);

    }

    public void updateCustomer() throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");

        Customer existCustomer = customerDAO.get(customerId);
        String message = null;
        if (existCustomer != null && existCustomer.getCustomerId() != customerId) {
            message = " Could not update the cusomer " + customerId + " bcoz ther is an existing customer with the same email";

        } else {
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String phone = request.getParameter("phonee");

            // you need to get these items from the db

            Customer updatedCustomer = new Customer();

            updatedCustomer.setPassword(password);
            updatedCustomer.setFullName(fullName);
            updatedCustomer.setPhone(phone);

            customerDAO.update(updatedCustomer);

            message = " The customer has been updated successfully !";
        }
        listCustomers(message);
    }

    public void deleteCustomers() throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        customerDAO.delete(id);
        String message = "Customer dleted successfully !";
        listCustomers(message);


    }

    public void showLogin() throws ServletException, IOException {
        String loginPage="fontend/login.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(loginPage);
        requestDispatcher.forward(request,response);


    }

    public void doLogin() throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer customer = customerDAO.checkLogin(email, password);
        if(customer == null){
            String message= "login failed,checkk ur rmail and password !";
            request.setAttribute("message",message);
            showLogin();
        }else{
            request.getSession().setAttribute("loggedCustomer",customer);
            showCustomerProfile();

        }
    }

    public void showCustomerProfile() throws ServletException, IOException {
        String profilePage= "/frontend/customer_profile.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(profilePage);
        requestDispatcher.forward(request,response);
    }

    public void showCustomerProfileEditForm() {
    }
}
