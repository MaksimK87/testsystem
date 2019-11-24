<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 14.11.2019
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>test system</title>
</head>
<body>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="authorization"/>
    Login:
    <input type="text" name="login" value=""/>
    <br/>
    Password:
    <input type="password" name="password" value=""/>
    <input type="submit" name="sign in" value="sign in"/>
</form>

<a href="Registration"> Go to registration page </a>

    </body>
</html>
