package com.example.demo2.controller.frontend;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "/*")
public class CustomerLoginFilter implements Filter {

    private  static final String[] LoginRequiredURLs={
            "/view_profile","/edit_profile","/update_profile"
    };

    private boolean isLoginRequired(String requesttUrl)
    {
        for (String loggingUrl: LoginRequiredURLs)
              {
                  if (requesttUrl.contains(loggingUrl)){
                      return true;
                  }

            
        }
        return  false;
    }
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

        String requestURL = httpServletRequest.getRequestURL().toString();
        
        if(!loggedin && isLoginRequired()){
            String loginPage="/frontend/login.jsp";
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(loginPage);
            requestDispatcher.forward(request,response);

        }else{

            chain.doFilter(request, response);

        }


    }
}
