<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>
<body>
    <div id="mainDiv">
        <a href=<c:url value="/first-page"/>>Go to first page</a><br><br>
        <a href=<c:url value="/customers"/>>Back</a><hr>
        <p><label>Name: </label>${cust.name}</p>
        <c:if test="${listC != null}">
            <table>
                <th>Request</th>
                <th>Dib</th>
                <th>StartDate</th>
                <th>DueDate</th>
                <th>Status</th>
                <th>DoneDate</th>
                <th>DeniedDate</th>
                <c:forEach var="list" items="${listC}">
                    <tr>
                        <td>${list.request}</td>
                        <td>${list.dib}</td>
                        <td>
                            <c:if test="${list.startDate != null}">
                                ${list.startDate.toLocalDate()} | ${list.startDate.toLocalTime()}
                            </c:if>
                        </td>
                        <td>${list.dueDate.toLocalDate()} | ${list.dueDate.toLocalTime()}</td>
                        <td>${list.status}</td>
                        <td>
                            <c:if test="${list.doneDate != null}">
                                ${list.doneDate.toLocalDate()} | ${list.doneDate.toLocalTime()}
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${list.deniedDate != null}">
                                ${list.deniedDate.toLocalDate()} | ${list.deniedDate.toLocalTime()}
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <br>
        <a href=<c:url value="/new-proposal/${cust.id}"/>>New proposal</a>
    </div>
</body>
</html>
