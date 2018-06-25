<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposal</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>

<body>
    <div id="mainDiv">
        <a href=<c:url value="/first-page"/>>Go to first page</a><br><br>
        <a href=<c:url value="/proposals"/>>Back</a><hr>
        <form method="post" action="${pageContext.request.contextPath}/proposals">
            <input type="hidden" value="${pr.id}" name="id"/>
            <p><label>Request: </label>${pr.request}</p>
            <p><label>Cost: </label>${pr.dib}</p>
                <c:if test="${pr.status eq 'NEW'}">
                    <p>
                        <label>Status: </label>
                        <label>
                            <select name="status">
                                <option value="${pr.status}">${pr.status}</option>
                                <option value="DONE">DONE</option>
                                <option value="DENIED">DENIED</option>
                            </select>
                        </label>
                    </p>
                </c:if>
            <p><label>Start date: </label>${pr.startDate.toLocalDate()} | ${pr.startDate.toLocalTime()}</p>
            <p><label>Due date: </label>${pr.dueDate.toLocalDate()} | ${pr.dueDate.toLocalTime()}</p>
            <c:if test="${pr.doneDate != null}">
                <p><label>Done date: </label>${pr.doneDate.toLocalDate()} | ${pr.doneDate.toLocalTime()}</p>
            </c:if>
            <c:if test="${pr.deniedDate != null}">
                <p><label>Denied date: </label>${pr.deniedDate.toLocalDate()} | ${pr.deniedDate.toLocalTime()}</p>
            </c:if>
            <button type="submit">Update</button>
        </form>
    </div>
</body>
</html>
