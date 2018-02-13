<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.07.2017
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>User id</th>
        <th>First name</th>
        <th>Last name</th>
        <th colspan=3>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><a href="UserController?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
            <td><a href="UserController?action=edit&id=<c:out value="${user.id}"/>">Update</a></td>
            <td><a href="CarController?action=list&userId=<c:out value="${user.id}"/>">CarView</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="UserController?action=add">Add user</a></p>
</body>
</html>
