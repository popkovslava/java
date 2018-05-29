<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.entity.Pages" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style type="text/css">
        <%@include file="../css/bootstrap.min.css" %>
        <%@include file="../css/style.css" %>
        <%@include file="../css/404.css" %>
    </style>
</head>

<body>
<%@include file="header.jsp" %>

<c:choose>
    <c:when test="${requestScope.page!=null}">
        <section>
            <%@include file="page.jsp" %>
        </section>
    </c:when>
    <c:otherwise>
        <section>
            <%@include file="404.jsp" %>
        </section>
    </c:otherwise>
</c:choose>

<%@include file="footer.jsp" %>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    <%@include file="../js/bootstrap.min.js" %>
</script>



