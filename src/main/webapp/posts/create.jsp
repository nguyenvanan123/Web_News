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
    <title>Post your article</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<style>
    h1 {
        color: orangered;
    }

    label {
        display: block;
        margin-top: 10px;
    }

    input[type="text"],
    textarea {
        width: 100%;
        padding: 5px;
        margin-top: 5px;
    }

    select {
        width: 100%;
        padding: 5px;
        margin-top: 5px;
    }

    input[type="submit"] {
        margin-top: 10px;
        padding: 10px 20px;
        background-color: orangered;
        color: #fff;
        border: none;
        cursor: pointer;

    }
    #title{
        width: 50%;
        background-color: seashell;
        border-radius: 5px;
    }
    #access{
        width: 20%;
        background-color: seashell
    ;}
    body{
        background-color: ghostwhite;
    }
    #timestamp{
        width: 20%;
    }

</style>
<body>
<script>
    window.addEventListener('DOMContentLoaded', function() {
        // Lấy thời gian hiện tại
        var currentDate = new Date();

        // Định dạng thời gian
        var timestamp = currentDate.toLocaleString();

        // Gán giá trị cho trường thời gian đăng
        document.getElementById('timestamp').value = timestamp;
    });

    function showNotification() {
        alert("Created a successful post !");
    }

</script>
<h1>Post your article</h1>
<%--action="/users"--%>
<form  method="post" action="/posts?action=create">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>





    <label for="content">Content:</label>
    <textarea id="content" name="content" required></textarea>

    <label for="timestamp">Time:</label>
    <input type="text" id="timestamp" name="timestamp" readonly>



    <label for="avatar">Avatar:</label>
    <textarea id="avatar" name="avatar" required></textarea>
    <%--    <input type="text" id="avatar" name="avatar" readonly>--%>


    <label for="shortdescription">Shortdescript</label>
    <textarea id="shortdescription" name="shortdescription" required></textarea>

    <label for="access">Access:</label>
    <%--    <td>${post.accessAllowed}</td>--%>
    <select id="access" name="access">
        <option value="true">Public</option>
        <option value="false">Private</option>
    </select>


    <label>
        <input type="submit" value="Create" onclick="showNotification()">
    </labeL>
</form>

<%--<script src="script.js"></script>--%>
</body>
</html>