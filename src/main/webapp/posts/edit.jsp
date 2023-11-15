<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenvanan
  Date: 12/10/2023
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        body{
            background-color: lightsalmon;


        }


        button{
            background-color:blanchedalmond;
        }

        .font{
            font-family: Arial, sans-serif;
        }

    </style>
</head>
<body>
<script>


</script>
<center>



</center>
<div align="center" class="font">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Posts
                </h2>
            </caption>
            <c:if test="${p != null}">
                <input type="hidden" name="id" value="<c:out value='${p.id}' />" />
            </c:if>
            <tr>
                <th>Title:</th>
                <td>
                    <input type="text" name="title" size="45"
                           value="${p != null ? p.title : ''}"
                           required/>
                </td>
            </tr>
            <tr>
                <th>Content:</th>
                <td>
                    <input type="text" name="content" size="45"
                           value="${p != null ? p.content : ''}"
                           required />
                </td>
            </tr>
            <tr>
                <th>Avatar:</th>
                <td>
                    <input type="text" name="avatar" size="45"
                           value="${p != null ? p.avatar : ''}"
                           required />
                </td>
            </tr>
            <tr>
                <th>Short description:</th>
                <td>
                    <input type="text" name="shortdescription" size="45"
                           value="${p != null ? p.shortdescription : ''}"
                           required />
                </td>
            </tr>
            <tr>
                <th>Access:</th>
                <td>
                    <select id="access" name="access">
                        <option value="true" ${p != null && p.access ? 'selected' : ''}>Public</option>
                        <option value="false" ${p != null && !p.access ? 'selected' : ''}>Private</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="submit" value="Save" onclick="" />
                </td>
            </tr>
            <a href="posts?action=listPosts">exit</a>
            </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>