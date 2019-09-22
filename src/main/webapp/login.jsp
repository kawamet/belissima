<%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 22/09/2019
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--ma wysylac do amin servlet. tam sprawdza czy istnieje--%>
<form action="/belissima_war/admin" method="post">
    User:
    <input type="text" name="user"><br>
    Password:
    <input type="password" name="password"><br>
    <input type="submit" value="Submit">

</form>


</body>
</html>
