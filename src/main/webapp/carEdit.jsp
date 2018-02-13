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
<form method="post" action="CarController" name="frmAddCar">
    USER_ID: <input type="text" readonly="readonly" name="userId"
               value="<c:out value="${userId}"/>"><br/>
    <%--ID: <input type="text" readonly="readonly" name="id"--%>
               <%--value="<c:out value="${car.id}"/>"><br/>--%>
    Model: <input type="text" name="model"
                  value="<c:out value="${car.model}"/>"><br/>
    Colour: <input type="text" name="colour"
                   value="<c:out value="${car.colour}"/>"><br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
