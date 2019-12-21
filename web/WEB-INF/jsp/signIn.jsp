<%@ page import="by.htp.jd2.maksimkosmachev.test.entity.Test" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 09.12.2019
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
<form action="Controller" method="post" class="formRegistration">
    <input type="hidden" name="command" value="authorization"/>
    <p>
        <span>Login:</span>
        <input type="text" name="login" value="" placeholder="enter login" autofocus required/>
    </p>
    <p>
        <span>Password:</span>
        <input type="password" name="password" value="" placeholder="enter password" required/>
        <input type="submit" name="sign in" value="sign in" class="inputBtn"/>
    </p>
</form>
<c:if test="${not empty param.errorMessage}">
    <c:out value="${param.errorMessage}"></c:out>
</c:if>

</br>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="go_to_registration_page"/>
    <input type="submit" value="registration"/>
</form>


<%
    List<Test> testList = (List<Test>) request.getAttribute("tests");
    for (Test test : testList) {
        out.println("Name: " + test.getTestName() + " duration " + test.getTestDuration() + " min.");%>
        <br/>
  <%      out.println();
    }
%>
<c:forEach var="test" items="${tests}" >
    <p><c:out value="${test.testName}"/></p>
    </c:forEach>

</body>
</html>
