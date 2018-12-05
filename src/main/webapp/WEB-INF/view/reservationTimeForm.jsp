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

    <table class = "table">
        <Tr>
            <td>From Date</td>
            <Td><form:input path="fromDate"/></Td>
            <Td><form:errors path="fromDate" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>To Date</td>
            <Td><form:input path="toDate"/></Td>
            <Td><form:errors path="toDate" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Period</td>
            <td><form:select path = "period" items="${periods}"/></td>
            <Td><form:errors path="period" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td>Hour</td>
            <Td><form:input path="hour"/></Td>
            <Td><form:errors path="hour" cssClass="error"/></Td>
        </Tr>
        <tr>
            <td colspan = "3">
                <input type = 'hidden' value = "1" name = "_page"/>
                <input type ='submit' value = "Previous" name = "_target0"/>
                <input type ='submit' value = "Next" name = "_target2"/>
                <input type ='submit' value = "Cancel" name = "_cancel"/>
            </td>
        </tr>
    </table>

</form:form>