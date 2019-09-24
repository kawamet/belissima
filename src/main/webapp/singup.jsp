<%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 24/09/2019
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing Up!</title>
</head>
<body>
<form action="/belissima_war/singupServlet" method="post">
    Email:
    <input type="text" name="user"><br>
    Password:
    <input type="password" name="password"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>


