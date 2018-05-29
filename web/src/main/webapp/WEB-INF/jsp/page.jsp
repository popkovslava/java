<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <c:forEach var="page" items="${requestScope.page}">
            <div class="col-md-10">
                <c:if test="${page.title!=null}">
                    <h1 class="text-center">${page.title}</h1>
                </c:if>
                <c:if test="${page.description!=null}">
                    <div class="text-center">${page.description}</div>
                </c:if>
            </div>
        </c:forEach>
    </div>
</div>