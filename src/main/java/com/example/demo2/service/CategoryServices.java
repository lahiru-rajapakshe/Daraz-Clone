package com.example.demo2.service;

import com.example.demo2.controller.admin.BaseServlet;
import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.entity.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class CategoryServices extends BaseServlet {

    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    //Generic constructor
    public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.entityManager = entityManager;


        categoryDAO = new CategoryDAO(entityManager);

    }

    public void listCategory(String message) throws ServletException, IOException {
        List<Category> listCategories = categoryDAO.listAll();
        request.setAttribute("listCategory", listCategories);
if(message!=null){

    request.setAttribute("message",message);
}
        String listPage = "category_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);


    }
    public void createCategory() throws ServletException, IOException {
        String name = request.getParameter("name");
        Category existCategory = categoryDAO.findByName(name);

        if(existCategory !=null){
            String message =" Could not create the category "+name+" already exists !";

            request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);


        }else {
            Category newCategory = new Category(name);
            categoryDAO.create(newCategory);
            String message ="New category created succesfully ";
            listCategory(message);


        }




    }

    public void listCategory() throws ServletException,IOException{
        listCategory(null);

    }

}
