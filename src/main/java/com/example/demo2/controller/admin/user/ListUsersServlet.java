package com.example.demo2.controller.admin.user;

import com.example.demo2.controller.BaseServlet;
import com.example.demo2.entity.Users;
import com.example.demo2.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "/admin/list_users", value = "/ListUsersServlet")
public class ListUsersServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserServices userServices = new UserServices(entityManager,request, response);
//        List<Users> listUsers = userServices.listUser();
//        request.setAttribute("listUsers", listUsers);

        userServices.listUser();


        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "1234");

            String sql = "SELECT user_id FROM Users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");

                System.out.println(user_id);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
