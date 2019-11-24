<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 21.11.2019
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="by.htp.jd2.maksimkosmachev.test.entity.User"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>My profile</title>
</head>
<body>
 <%
   User user=(User) request.getAttribute("user");
   out.println(user.getName());
     out.println(user.getSurname());
     out.println(user.getRole());
     out.println(user.getEmail());
 %>
</body>
</html>
