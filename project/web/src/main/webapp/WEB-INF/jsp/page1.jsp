<%--
  Created by IntelliJ IDEA.
  User: slon
  Date: 29.04.2018
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 style="text-align: center">${requestScope.request1.name}</h1>
<h2 style="text-align: center">${requestScope.request1.massage}</h2>
<div style="text-align: center"><%@ include file="menu.jsp"%></div>

<c:if test="${not empty requestScope.request3.text1}">
    <div style="text-align: center">${requestScope.request3.text1}</div>
</c:if>


</body>
</html>
