<%--
  Created by IntelliJ IDEA.
  User: TAM TU
  Date: 20/09/2024
  Time: 4:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="control-servlet">
    <p>Email: <input type="email" name="email"></p>
    <p>Password: <input type="password" name="password"></p>
    <p><input type="submit" value="Login"></p>
    <% if(request.getAttribute("message") != null) { %>
        <p style="color: red"><%= request.getAttribute("message") %></p>
    <% } %>
    <input type="hidden" value="LogIn" name="action">
</form>
</body>
</html>
