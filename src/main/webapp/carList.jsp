<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.11.2017
  Time: 16:16
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
        <th>userId</th>
        <th>ID</th>
        <th>Model</th>
        <th>Colour</th>
        <th colspan=3>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.userId}"/></td>
            <td><c:out value="${car.id}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.colour}"/></td>
            <td><a href="CarController?action=delete&id=${car.id}&userId=${car.userId}">Delete</a></td>
            <td><a href="CarController?action=edit&id=${car.id}&userId=${car.userId}">Update</a></td>
            <td><a href="PSController?action=list&carId=${car.id}">Parking Service</a></td>
    </c:forEach>
    </tbody>
</table>
<p><a href="CarController?action=add&userId=${userId}">Add car</a></p>
<p><a href="UserController?action=list">Go to UserList</a></p>

</body>
</html>


