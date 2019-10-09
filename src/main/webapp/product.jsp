<%@ page import="karolina.controller.LangProvider" %><%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 22/09/2019
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get product</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="/belissima_war/product" method="post">
    <%--ID:
    <input type="text" name="id"><br>--%>
    <%= LangProvider.INSTANCE.getMessage("itemname")%>
    <input type="text" name="itemName"><br>
    <%= LangProvider.INSTANCE.getMessage("category")%>
    <input type="text" name="category"><br>
    <%= LangProvider.INSTANCE.getMessage("itemamount")%>
    <input type="text" name="itemAmount"><br>
    <%= LangProvider.INSTANCE.getMessage("itemprice")%>
    <input type="text" name="price"><br>
    <input type="submit" value="<%= LangProvider.INSTANCE.getMessage("submit")%>"><br>

</form>


</body>
</html>
