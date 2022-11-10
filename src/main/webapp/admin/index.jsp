<%--
  Created by IntelliJ IDEA.
  User: lara
  Date: 11/9/22
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookStore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>


<h2 align="center">Administrative Dashboard</h2>
<hr width="60%"/>
<div align="center">
    <h2>Quick Action</h2>
    <b>
        <a href="create_book">New Book</a>&nbsp;
        <a href="create_user">new user</a>&nbsp;
        <a href="create_category">New category</a>&nbsp;
        <a href="create_customer">New Customer</a>&nbsp;

    </b>

</div>
<hr width="60%"/>
<div align="center">
    <h2>Recent Sales </h2>

</div>
<hr width="60%"/>
<div align="center">
    <h2>Recent Reviews </h2>

</div>
<hr width="60%"/>
<div align="center">
    <h2>Statistics</h2>


</div>

<jsp:directive.include file="footer.jsp"/>

</body>
</html>
