<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 21.11.2019
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form action="Controller" method="post">

    <input type="hidden" name="command" value="registration"/>
    Name:
    <input type="text" name="name" value=""/>
    <br/>
    Surname:
    <input type="text" name="surname" value=""/>
    <br/>
    email:
    <input type="text" name="email" value=""/>
    <br/>
    Choose role:
    <select name="role" required>
        <option value="STUDENT">Student</option>
        <option value="TUTOR">Tutor</option>
        <option value="ADMINISTRATOR">Administrator</option>
    </select>
    <br/>
    Login:
    <input type="text" name="login" value=""/>
    <br/>
    Password:
    <input type="text" name="password" value=""/>

    <input type="submit" name="sign up" value="sign up"/>
</form>

</body>
</html>
