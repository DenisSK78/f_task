<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>
    <body>
        <div id="mainDiv">
            <a href=<c:url value="/first-page"/>>Go to first page</a><hr>
            <table style="border-collapse: collapse">
                <th>ID</th>
                <th>Name</th>
                <th>Proposal</th>
                <c:forEach var="cast" items="${listC}">
                    <tr>
                        <td>${cast.id}</td>
                        <td>${cast.name}</td>
                        <td><a href=<c:url value="/customer/${cast.id}"/>>Info</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
