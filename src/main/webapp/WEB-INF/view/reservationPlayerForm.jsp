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
        <td>Player name</td>
        <Td><form:input path="player.name"/></Td>
        <Td><form:errors path="player.name" cssClass="error"/></Td>
    </Tr>
        <Tr>
            <td>Player phone</td>
            <Td><form:input path="player.phone"/></Td>
            <Td><form:errors path="player.phone" cssClass="error"/></Td>
        </Tr>
        <tr>
            <td colspan = "3">
                <input type = 'hidden' value = "2" name = "_page"/>
                <input type ='submit' value = "Previous" name = "_target1"/>
                <input type ='submit' value = "Next" name = "_finish"/>
                <input type ='submit' value = "Cancel" name = "_cancel"/>
            </td>
        </tr>
    </table>

</form:form>