package com.example.demo2.controller.frontend;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "/*")
public class CustomerLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

        
        if(path.startsWith("/admin")){
            chain.doFilter(request, response);
            return;
        }
        boolean loggedin =session!= null &&  session.getAttribute("loggedCustomer") != null;

        if(!loggedin && path.startsWith("view_profile")){
            String loginPage="/frontend/login.jsp";
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(loginPage);
            requestDispatcher.forward(request,response);

        }else{

            chain.doFilter(request, response);

        }


    }
}
