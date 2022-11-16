<%--
  Created by IntelliJ IDEA.
  User: lara
  Date: 11/10/22
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Book</title>
    <script defer type="text/javascript" src="./node_modules/jquery/dist/jquery.min.js"></script>
    <script defer type="text/javascript" src="./node_modules/jquery-validation/dist/jquery.validate.min.js"></script>
    <script defer type="text/javascript" src="./node_modules/jquery-ui/dist/jquery-ui.js"></script>
    <script defer type="text/javascript" src="./node_modules/jquery-ui/dist/jquery-ui.min.js"></script>
<%--    <script defer type="text/javascript" src="./node_modules/jquery-ui/dist/themes/"></script>--%>
    <link rel="stylesheet" href="./node_modules/jquery-ui/dist/themes/blitzer/jquery-ui.min.css">
</head>
<body>
<jsp:directive.include file="header.jsp"/>


<h2 align="center">
    <c:if test="${user != null}">
Edit Book
    </c:if>

    <c:if test="${user != null}">
        Create New Book
    </c:if>

</h2>
<hr width="60%"/>
<div align="center">
    <c:if test="${user != null}">
        <form action="update_user" method="POST"    id="userForm">
            <input type="hidden" name="userId" value="${user.userId}">
    </c:if>
        <c:if test="${user == null}">
        <form action="create_user" method="POST" id="userForm" >
            </c:if>

        <table>
            <tr>
                <td align="right">Email : </td>
                <td align="left"><input id="email" type="text" name="email" size="20" value="${user.email}" /></td>
            </tr>

            <tr>
                <td align="right">FullName : </td>
                <td  align="left"><input id="fullName" type="text" name="fullName" size="20" value="${user.fullName}" /></td>
            </tr>

            <tr>
                <td align="right">Password : </td>
                <td  align="left"><input id="password" type="password" name="password" size="20" value="${user.password}" /></td>
            </tr>
<tr>
    <td>&nbsp;</td>
</tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                    <input type="button" value="Cancel" onclick="javascript:history.go(-1);"/>
                </td>

            </tr>


        </table>
    </form>
</div>


<jsp:directive.include file="footer.jsp"/>

</body>
<script type="text/javascript">
    $( function() {
        $( "#datepicker" ).datepicker();
    } );

    $(document).ready(function (){
        $("#userForm").validate({
       rules:{
           email:{
               required :true,
               email:true,
           },
           fullname:"required",
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
</html>
