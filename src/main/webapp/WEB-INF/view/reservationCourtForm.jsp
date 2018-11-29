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
            <td>Court Name</td>
            <Td><form:input path="courtName"/></Td>
            <Td><form:errors path="courtName" cssClass="error"/></Td>
        </Tr>
        <Tr>
            <td colspan="3">
                <input type ='hidden' value = "0" name = "_page"/>
                <input type ='submit' value = "Next" name = "_target1"/>
                <input type ='submit' value = "Cancel" name = "_cancel"/>
            </td>
        </Tr>
    </table>
</form:form>