<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<html>
<head>
    <title>Statistics</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>

<body>
    <div id="mainDiv">
    <a href=<c:url value="/first-page"/>>Go to first page</a><br><br>
    <a href=<c:url value="/proposals"/>>Back</a><hr>
    <p><label>Total offers: </label>${total.toString()}</p>
    <p><label>Done: </label>${done.toString()}</p>
    <p><label>Denied offers: </label>${denied.toString()}</p>
        <p><label>New proposals: </label>${pNew.toString()}</p>
    </div>
</body>
</html>