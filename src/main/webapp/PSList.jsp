<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.12.2017
  Time: 13:55
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
        <th>CarId</th>
        <th>ID</th>
        <th>Charge</th>
        <th>Time1</th>
        <th>Time2</th>
        <th>Price</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${PS}" var="PS">
        <tr>
            <td><c:out value="${PS.carId}"/></td>
            <td><c:out value="${PS.id}"/></td>
            <td><c:out value="${charge}"/></td>
            <td><fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${PS.time1}"/></td>
            <td><fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${PS.time2}"/></td>
            <td><c:out value="${PS.price}"/></td>
            <td><a href="PSController?action=edit&id=${PS.id}&carId=${PS.carId}">Update</a></td>
            <td><a href="PSController?action=delete&id=${PS.id}&carId=${PS.carId}">Delete</a></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<p><a href="PSController?action=add&carId=${carId}">Add Service</a></p>
<%--<p><a href="CarController?action=list&userId=${}">Go to CarList</a></p>--%>
<p><a href="UserController?action=list">Go to UserList</a></p>


</body>
</html>
