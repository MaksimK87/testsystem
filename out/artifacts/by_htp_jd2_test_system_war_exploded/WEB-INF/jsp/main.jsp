<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="by.htp.jd2.maksimkosmachev.test.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="by.htp.jd2.maksimkosmachev.test.entity.User"
         pageEncoding="UTF-8" %>
<br>
<head>
    <title>Main</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="resources.local" var="loc"/>

    <fmt:message bundle="${loc}" key="local.signin.lang_button_ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.signin.lang_button_en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.main.signout_button" var="sign_out"/>
    <fmt:message bundle="${loc}" key="local.main.add_new_test_button" var="add_new_test"/>
</head>
<h1>Test system web application </h1>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="change_language"/>
    <input type="hidden" name="lang" value="ru"/>
    <input type="submit" value="${ru_button}"/>
</form>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="change_language"/>
    <input type="hidden" name="lang" value="en"/>
    <input type="submit" value="${en_button}"/>
</form>
<h4>Your account:</h4>
    Name:<c:out value="${user.name}"/>
<br>Surname:<c:out value="${user.surname}"/>
<br>Role:<c:out value="${user.role}"/><br>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="go_to_add_test_page"/>
    <input type="submit" value="${add_new_test}"/>
</form>

<form action="Controller" method="post">

    <input type="hidden" name="command" value="sign_out" required/>

    <input type="submit" name="sign_out" value="${sign_out}"/>
</form>

</body>
</html>
