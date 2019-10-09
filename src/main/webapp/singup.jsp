<%@ page import="karolina.controller.LangProvider" %><%--
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="/belissima_war/singupServlet" method="post">
    <%= LangProvider.INSTANCE.getMessage("useremail")%>
    <input type="text" name="user"><br>
    <%= LangProvider.INSTANCE.getMessage("password")%>
    <input type="password" name="password"><br>
    <input type="submit" value="<%= LangProvider.INSTANCE.getMessage("submit")%>">
</form>

</body>
</html>


