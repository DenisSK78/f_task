<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<html>
<head>
    <title>Proposals</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>
    <body>
    <div id="mainDiv">
        <a href=<c:url value="/first-page"/>>Go to first page</a><br><br>
        <a href=<c:url value="/statistics"/>>Statistics</a><hr>
            <h1>Proposals</h1>
            <table style="border-collapse: collapse">
                <th>Request</th>
                <th>Dib</th>
                <th>StartDate</th>
                <th>DoeDate</th>
                <th>Status</th>
                <th>Update</th>
                <c:forEach var="list" items="${listP}">
                    <tr>
                        <td>${list.request}</td>
                        <td>${list.dib}</td>
                        <td>${list.startDate.toLocalDate()} | ${list.startDate.toLocalTime()}</td>
                        <td>${list.dueDate.toLocalDate()} | ${list.dueDate.toLocalTime()}</td>
                        <td>${list.status}</td>
                        <c:if test="${list.status.toUpperCase() eq 'NEW'}" >
                        <td><a href=<c:url value="/proposal/${list.id}"/>>Update</a></td>
                        </c:if>
                        <c:if test="${list.status.toUpperCase() != 'NEW'}" >
                            <td>Close</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
