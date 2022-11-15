package com.example.demo2.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "/admin/*")
public class AdminLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = session != null  && session.getAttribute("useremail") != null;
        String logginURI = httpRequest.getContextPath() + "/admin/login";
        boolean loggingRequest = httpRequest.getRequestURI().equals(logginURI);

        

        if(loggedIn || loggingRequest){
            System.out.println("User logged in");
            chain.doFilter(request, response);

        }else{
            System.out.println("user not logged in");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);

        }

    }
}
