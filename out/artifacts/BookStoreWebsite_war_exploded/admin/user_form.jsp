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
    <title>Create New User</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>


<h2 align="center">Create New User</h2>
<hr width="60%"/>
<div align="center">

    <form action="create_user" method="POST"  onsubmit="return validateFormInput()"  >

        <table>
            <tr>
                <td align="right">Email : </td>
                <td align="left"><input id="email" type="text" name="email" size="20" /></td>
            </tr>

            <tr>
                <td align="right">FullName : </td>
                <td  align="left"><input id="fullName" type="text" name="fullName" size="20" /></td>
            </tr>

            <tr>
                <td align="right">Password : </td>
                <td  align="left"><input id="password" type="password" name="password" size="20" /></td>
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
function validateFormInput(){
    var fieldEmail= document.getElementById("email");
    var fieldFullName = document.getElementById("fullName");
    var fieldPassword = document.getElementById("password");


    if(fieldEmail.value.length == 0){
        alert("Email is Required !");
        fieldEmail.focus();
        return false;
    }
    if(fieldFullName.value.length == 0){
        alert("Full name is Required !");
        fieldFullName.focus();
        return false;
    }

    if(fieldPassword.value.length == 0){
        alert("Password is Required !");
        fieldPassword.focus();
        return false;
    }
    return  true;


}
</script>
</html>
