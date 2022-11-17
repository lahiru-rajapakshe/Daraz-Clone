<%--
  Created by IntelliJ IDEA.
  User: lara
  Date: 11/8/22
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book in ${category.name}Daraz-clone App</title>

</head>
<body>
<jsp:directive.include file="../admin/header.jsp" />

<div align="center">
<h2>${category.name}</h2>
</div>

<div align="center">
    <div style="display: inline-block">
        <c:foreach items="${listBooks}" var="book">
            <a href="view_book?id${book.bookId}">
                <img src="data:image/jpg;base64,${book.base64Image} width="84" height="110" />
            </a>
            <h4>
                <a href="view_book?id${book.bookId}">
                    <b>${book.title}</b>
                </a></h4>
            <h4>Rating</h4>
            <h4><i>by ${book.author}</i></h4>
            <h4><b>${book.price}</b></h4>

        </c:foreach>
    </div>
</div>

<jsp:directive.include file="Footer.jsp" />
</body>
</html>
