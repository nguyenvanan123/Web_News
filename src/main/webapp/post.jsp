<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenvanan
  Date: 10/11/2023
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bài viết mới</title>
</head>
<style>
    h2,h1{
        text-align: center;
    }
    body{
        background-color: blanchedalmond;

    }
</style>
<script>
    function redirectToPage() {
        window.location.href = "home2.jsp";
    }
</script>
<body>


<c:set var="userName" value="${insertContent}"></c:set>
<h1>Bài viết mới</h1>
<h2>Tiêu đề: ${userName.title}</h2>
<button onclick="redirectToPage()">exit</button>
<p>Nội dung: ${userName.content}</p>
<p>Time: ${userName.timestamp}</p>
<%--<p>Avatar: ${userName.avatar}</p>--%>
<img src="${userName.avatar}">
<br>
<a href="${userName.avatar}" target="_blank" title="FULL HD KHUM CHE">FULL HD KHUM CHE</a>
<br>
<p>Content: ${userName.shortdescription}</p>

</body>
</html>