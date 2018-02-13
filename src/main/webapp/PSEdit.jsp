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
<form method="post" action="PSController" name="frmAddPS">
    CarId  <input type="text" readonly="readonly" name="carId"
                   value="<c:out value="${carId}"/>"><br/>
    <%--ID: <input type="text" readonly="readonly" name="id"--%>
               <%--value="<c:out value="${PS.id}"/>"> <br/>--%>
    Charge: <input type="text" readonly="readonly" name="charge"
                   value="<c:out value="${charge}"/>"/>price for 1 hour<br/>
    Time1: <input type="text" name="time1"
                  value="<fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${PS.time1}"/>"/><br/>
    Time2: <input type="text" name="time2"
                  value="<fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${PS.time2}"/>"/><br/>
    <%--Price: <input type="text" readonly = "readonly" name="price"--%>
                  <%--value="<c:out value="${PS.price}"/>"><br/>--%>
    <input type="submit" value="Submit"/>
</form>



</body>
</html>
