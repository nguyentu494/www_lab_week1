<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account" %>
<%@ page import="java.util.*" %>
<%--

  Created by IntelliJ IDEA.
  User: TAM TU
  Date: 20/09/2024
  Time: 7:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% Object a = request.getServletContext().getAttribute("account");
    List<Account> accounts = (List<Account>) request.getServletContext().getAttribute("accounts");

%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin</h1>
<h2>Welcome to Admin page</h2>
<p><%a.toString();%></p>
<table border="1">
    <caption>Danh sach user</caption>
    <tr>
        <th>Username</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Role</th>
        <th>Active</th>
        <th>Update</th>
    </tr>
    <c:forEach items="<%=accounts%>" var="account">
        <tr>
            <td>${account.getaccountId()}</td>
            <td>${account.getfullName()}</td>
            <td>${account.email}</td>
            <td>
                <c:forEach items="${account.grantAccesses}" var="ga">
                    ${ga.grantAccessId.role.getRoleId()},
                </c:forEach>
            </td>
            <td>${account.status}</td>
            <td><a href="#">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
