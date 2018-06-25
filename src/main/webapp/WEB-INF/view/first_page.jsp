<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First page</title>
    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/style.css" th:href="@{/css/style.css}" />
</head>
    <body>
    <div id="mainDiv">
        <h1>First page</h1>
        <button onclick="document.location.href='proposals'">Admin</button>
        <button onclick="document.location.href='customers'">Customer</button>
    </div>
    </body>
</html>
