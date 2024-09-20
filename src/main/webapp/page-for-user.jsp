<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account" %><%--
  Created by IntelliJ IDEA.
  User: TAM TU
  Date: 20/09/2024
  Time: 4:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% Object a = request.getServletContext().getAttribute("account"); %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Profile</h1>
<p><%= a.toString() %></p>
</body>
</html>
