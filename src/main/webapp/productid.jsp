<%@ page import="karolina.controller.LangProvider" %><%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 27/09/2019
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<form action="/belissima_war/product" method="get">
    <input type="text" name="id">
    <input type="submit" value="<%= LangProvider.INSTANCE.getMessage("findproduct")%>">
</form>

</body>
</html>
