<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 19.12.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating new test</title>
    <p>Create new test</p>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="add_test_question"/>
        Enter test's name:
        <p><input type="text" name="testName" value="" placeholder="enter name" required/>
        <p/>
        Enter test's duration (minutes):
        <p><input type="number" name="duration" min="0" value="" placeholder="enter duration in minutes" required/>
        </p>
        Enter answer quantity:
        <p><input type="number" name="answerQuantity" min="2" value="" placeholder="answer quantity" required></p>
        Enter question:
        <p>
            <textarea name="questionText" cols="40" rows="3" placeholder="enter question" required></textarea>

        <p>
            <input type="submit" value="next">
        </p>


    </form>
</head>
<body>

</body>
</html>
