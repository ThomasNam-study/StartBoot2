<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2><sp:message code = "welcome.title"/> to Court Reservation System</h2>

Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/><br/>
Handing time : ${handlingTime} ms
</body>
</html>
