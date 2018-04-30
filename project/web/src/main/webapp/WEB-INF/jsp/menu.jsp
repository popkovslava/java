<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty requestScope.request2.menu}">
    <div>
        <c:forEach var="item" items="${requestScope.request2.menu}">
            <a href="${item}">${item}</a><br>
        </c:forEach>
    </div>
</c:if>

