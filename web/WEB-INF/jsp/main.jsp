<%@ page import="by.htp.jd2.maksimkosmachev.test.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 21.11.2019
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="by.htp.jd2.maksimkosmachev.test.entity.User"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<% User user = (User) session.getAttribute("user");%>
<br/> <%
    out.println(user.getName());
    out.println(user.getSurname());
    out.println(user.getRole());

%>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="go_to_add_test_page"/>
    <input type="submit" value="Add new test"/>
</form>


</body>
</html>
