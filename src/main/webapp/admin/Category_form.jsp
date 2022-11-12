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


<h2 align="center">
    <c:if test="${category != null}">
        Edit category
    </c:if>

    <c:if test="${category != null}">
        Create New Category
    </c:if>

</h2>
<hr width="60%"/>
<div align="center">
    <c:if test="${category != null}">
    <form action="update_category" method="POST"  onsubmit="return validateFormInput()"  >
        <input type="hidden" name="userId" value="${category.userId}">
        </c:if>
        <c:if test="${category == null}">
        <form action="create_category" method="POST"  onsubmit="return validateFormInput()"  >
            </c:if>

            <table>
                <tr>
                    <td align="right">Name : </td>
                    <td align="left"><input id="name" type="text" name="name" size="20" value="${category.name}" /></td>
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
        var fieldName= document.getElementById("name");



        if(fieldName.value.length == 0){
            alert("Cattegory Name is Required !");
            fieldName.focus();
            return false;
        }

        return  true;


    }
</script>
</html>
