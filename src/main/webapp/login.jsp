<%@ page import="karolina.controller.LangProvider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%--ma wysylac do amin servlet. tam sprawdza czy istnieje--%>
<form action="/belissima_war/login" method="post">
    <%= LangProvider.INSTANCE.getMessage("useremail")%>
    <input type="text" name="user"><br>
    <%= LangProvider.INSTANCE.getMessage("password")%>
    <input type="password" name="password"><br>
    <input type="submit" value="Log In">

</form>

<button><a href="/belissima_war/singup.jsp">Sign Up</a></button><br>


</body>
</html>
