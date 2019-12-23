<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 23.12.2019
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="hidden" name="command" value="add_test_question"/>
    <p><input type="number" name="answerQuantity" min="2" value="" placeholder="answer quantity">
        Enter question:
    <p>
        <textarea name="questionText" cols="40" rows="3" placeholder="enter question" required></textarea>

    <p>
</form>
</body>
</html>
