package com.example.demo2.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerServices {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
    }

    public void listCustomers() {
        
    }
}
