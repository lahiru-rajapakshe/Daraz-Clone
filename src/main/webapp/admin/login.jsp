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
    <script type="text/javascript" src="./node_modules/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="./node_modules/jquery-validation/dist/jquery.validate.min.js"></script>
</head>
<body>
<div align="center">
    <h1>Book Store Administration</h1>
    <h2>Admin Login</h2>

    <form action="login" id="loginForm" method="post">
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
<script type="text/javascript">
    $(document).ready(function (){
        $("#loginForm").validate({
            rules:{
                email:{
                    required :true,
                    email:true,
                },

                password:"required",
            },
            messages:{
                email: {
                    required: "please enter email",
                    email:"please enter a valid email adresss",

                },
                fullname: "please enter the fullname",
                password: "please enter the password",
            },

        });
    });

</script>
</body>
</html>
