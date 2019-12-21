<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 12.12.2019
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="by.htp.jd2.maksimkosmachev.test.entity.User"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
Sorry,something went wrong...
<br/>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="go_to_sign_in_page"/>
    <input type="submit" value="go to sign in page"/>
</form>
</body>
</html>
