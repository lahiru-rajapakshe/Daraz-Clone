<%--
  Created by IntelliJ IDEA.
  User: lara
  Date: 11/8/22
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>

<%
    String user_id = request.getParameter("user_id");
    String drivername= "com.mysql.cj.jdbc.Driver";
    String connectionUrl="jdbc:mysql://localhost:3306/";
    String dbName="bookstoredb";
    String userName="root";
    String password="Addy@789**$";

    try{
        Class.forName(drivername);
    }catch (ClassNotFoundException e){
e.printStackTrace();
    }

    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;



%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your App</title>
</head>
<body>

<h1>Hi there</h1>
<table>
    <tr>

        <td>user_id</td>
        <td>password</td>
        <td>email</td>

    </tr>


<%
    try{
        connection=DriverManager.getConnection(connectionUrl+dbName,userName,password);
        statement=connection.createStatement();
        String sql="Select * from Users";

        resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            %>

<td><%= resultSet.getString("user_id") %></td>
<td><%= resultSet.getString("password") %></td>
<td><%= resultSet.getString("email") %></td>

</tr>
        }
<%
    }
        connection.close();
    }catch (Exception e){
        e.printStackTrace();
    }
%>
</table>
    }

</body>
</html>
