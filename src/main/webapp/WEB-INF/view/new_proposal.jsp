<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New page</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>
    <body>
        <div id="mainDiv">
            <a href=<c:url value="/first-page"/>>Go to first page</a><hr>
            <form action="${pageContext.request.contextPath}/customer" method="post">
                <input type="hidden" value="${cust.id}" name="id">
                <p>
                    <div class="labelInput"><label>Request:</label></div>
                    <label class="LInp"><input type="text" name="request"></label>
                </p>
                <p>
                    <div class="labelInput"><label>Dib: </label></div>
                    <label class="LInp"><input type="number" name="dib" step="0.01"></label>
                </p>

                <p>
                    <div class="labelInput"><label>Due date: </label></div>
                    <label class="LInp"><input type="datetime-local" step=60 name="time" value="${strTime}"></label>
                </p>
                <button type="submit">Save</button>
            </form>
        </div>
    </body>
</html>
