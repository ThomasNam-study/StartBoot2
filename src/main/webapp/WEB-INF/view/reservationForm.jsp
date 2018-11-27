<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="top.jsp"/>

<style>

    .error {
        color: #ff0000;
        font-weight: bold;
    }

</style>

<form:form method = "post" modelAttribute="reservation">
    <form:errors path="*" cssClass="error"/>
    <table class = "table">
        <Tr>
            <td>Court Name</td>
            <Td><form:input path="courtName"/></Td>
            <Td><form:errors path="courtName" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Date</td>
            <Td><form:input path="date"/></Td>
            <Td><form:errors path="date" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Hours</td>
            <Td><form:input path="hour"/></Td>
            <Td><form:errors path="hour" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Player name</td>
            <Td><form:input path="player.name"/></Td>
            <Td><form:errors path="player.name" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Player phone</td>
            <Td><form:input path="player.phone"/></Td>
            <Td><form:errors path="player.phone" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Player phone</td>
            <Td><form:select path="sportType" items="${sportTypes}" itemValue="id" itemLabel="name"/></Td>
            <Td><form:errors path="sportType" cssClass="error"/></Td>
        </Tr>

        <tr>
            <td colspan="3">
                <input type = "submit"/>
            </td>
        </tr>
    </table>

</form:form>