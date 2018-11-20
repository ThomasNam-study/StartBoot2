<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    Court Name
    <input type = 'text' name = 'courtName' value="${courtName}"/>
    <input type = 'submit' value = "Query"/>
</form>

<table border = "1">
    <tr>
        <th>Court Name</th>
        <th>Date</th>
        <th>Hour</th>
        <th>Player</th>
    </tr>
    <c:forEach items="${list}" var = "r">
        <tr>
            <Td>${r.courtName}</Td>
            <Td><fmt:formatDate value="${r.date}"/></Td>
            <Td>${r.hour}</Td>
            <Td>${r.player.name}</Td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
