<%@ page import="karolina.controller.LangProvider" %>
<%--musze wydrukowac tablice ze wszystkimi produktami + opcja kup dla uzytkownika ktory jest zalogowany
to co kupuje trafia to tabeli id produkt + id uzytkowniak--%>


<%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 26/09/2019
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--bardzo wazne przez to mi nie dziala caly pojetk!--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<table border="1">
    <tr>
        <th>id</th>
        <th><%= LangProvider.INSTANCE.getMessage("itemname")%></th>
        <th><%= LangProvider.INSTANCE.getMessage("category")%></th>
        <th><%= LangProvider.INSTANCE.getMessage("itemamount")%></th>
        <th><%= LangProvider.INSTANCE.getMessage("itemprice")%></th>
        <th><%= LangProvider.INSTANCE.getMessage("action")%></th>


    </tr>
    <c:forEach var="tempProduct" items="${product_list}">

        <c:url var="tempLink" value="buy">
            <c:param name="command" value="BUY" />
            <c:param name="productId" value="${tempProduct.id}" />
        </c:url>


        <tr>
            <td>${tempProduct.id}</td>
            <td>${tempProduct.itemName}</td>
            <td>${tempProduct.itemName}</td>
            <td>${tempProduct.itemAmount}</td>
            <td>${tempProduct.price}</td>
            <td><a href="${tempLink}">Buy</a></td>

        </tr>

    </c:forEach>

</table>

</body>
</html>