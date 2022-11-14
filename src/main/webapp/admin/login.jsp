<%--
  Created by IntelliJ IDEA.
  User: lara
  Date: 11/14/22
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | Login</title>
</head>
<body>
<div align="center">
    <h1>Book Store Administration</h1>
    <h2>Admin Login</h2>

    <form action="login" id="formLogin" method="post">
        <table>
            <tr>
                <td>Email : </td>
                <td><input type="text" name="email" id="email" size="20"></td>
            </tr>

            <tr>
                <td>Password : </td>
                <td><input type="password" name="password" id="password" size="20"></td>
            </tr>

            <tr>
                <td>
                    <button type="submit">Login</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
