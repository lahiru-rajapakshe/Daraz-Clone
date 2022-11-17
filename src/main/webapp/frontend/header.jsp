<%--
  Created by IntelliJ IDEA.
  User: lara
  Date: 11/8/22
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header | Daraz</title>
</head>
<body>
<div align="center">
    <div>
        <img src="../images/BookstoreLogo.png" alt="Logo">
    </div>
    <div>
        <form action="search" method="get">
            <input type="text" name="keyword" size="50">
            <input type="submit" value="search">


            <a href="header.jsp">Sign In</a>
            <a href="register">Register</a>
            <a href="view_cart">Cart</a>

        </form>

    </div>
    <div>&nbsp;</div>
    <div>
        <c:foreach var="category" items="${listCategory}" varStatus="status">
            <a href="view_category?id=${category.categryId}">
                <font size="+1"><b><c:out value="${category.name}"/></b></font>


            </a>
            <c:if test="${not status.last}">
                &nbsp; | &nbsp;
            </c:if>
        </c:foreach>
    </div>

</div>

</body>
</html>
