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
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Manage users |  Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<h2 align="center">Welcome, Admin <a href="logout">logout</a></h2>

<h2 align="center">User Management</h2>
<div align="center">
    <a href="user_form.jsp">Create new User</a>
</div>
<br>
<c:if test="${message != null}">
    <div align="center">
        <h4><i>${message}</i></h4>
    </div>

</c:if>

<div align="center">
<table border="1" cellpadding="5">
    <tr>

        <th>User ID</th>
        <th>Email</th>
        <th>Full Name</th>
   <th>Action </th>

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
    <td><%= resultSet.getString("email") %></td>
    <td><%= resultSet.getString("full_name") %></td>
<td><a href="edit_user?id=${user.userId}">Edit</a>&nbsp;
    <a href="javascript:confirmDelete(${user.userId})">Delete</a>

</td>

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

</div>

<div align="center">

</div>

<div align="center">

</div>

<div align="center">


</div>

<jsp:directive.include file="footer.jsp"/>
<script>
    function  confirmDelete(){
        if (confirm("Are you sure. you need tto delete the user with ID "+ userId+" ? ")){
            window.location="delete_user?id="+userId;

        }

    }
</script>
</body>
</html>
