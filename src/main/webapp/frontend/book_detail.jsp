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
    <title>${book.ttitle} Daraz-clone App</title>

</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>${book.author}</h2>

    <table width="80%" border="0">
        <tr>
            <td colspan="3" align="left">
                <h2>${book.title}</h2>

            </td>
        </tr>
        <tr>
            <td>
                <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300" alt="">
            </td>
        </tr>
        <tr>
            <td>
                Rating *****
            </td>
            <td>
                $${bok.price}
                <br> <button type="submit">Add to cart</button>
            </td>
        </tr>
        <tr>
            <td>
                ${book.description}
            </td>
        </tr>
        <tr>
            <td>
                Customer Reviews
            </td>
            <td>Write a Customer Review</td>
        </tr>
    </table>

</div>
<h1>Best Selling Books</h1>
<h1>Featured Books</h1>
</div>

<jsp:directive.include file="Footer.jsp"/>
</body>
</html>
