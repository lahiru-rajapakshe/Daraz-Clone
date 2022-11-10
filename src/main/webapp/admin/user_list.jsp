
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
    <a href="">Create new User</a>
</div>
<br>

<div align="center">
<table border="1">
    <tr>
        <th>Index</th>
        <th>Id</th>
        <th>Email</th>
        <th>Full Name</th>
        <th>Actions</th>

    </tr>
    <c:forEach var="user" items="${lilstUsers}" varStatus="status">
<tr>

    <td>${status.index}</td>
    <td>${status.id}</td>
</tr>
    </c:forEach>
</table>
</div>

<div align="center">

</div>

<div align="center">

</div>

<div align="center">


</div>

<jsp:directive.include file="footer.jsp"/>

</body>
</html>