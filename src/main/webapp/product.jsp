<%--
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
</head>
<body>
<form action="/belissima_war/product" method="post">
    <%--ID:
    <input type="text" name="id"><br>--%>
    Item Name
    <input type="text" name="itemName"><br>
    Category
    <%--tutaj mozna by wrzucic combobox--%>
    <input type="text" name="category"><br>
    Item Amount
    <input type="text" name="itemAmount"><br>
    Item price
    <input type="text" name="price"><br>
    <input type="submit" value="Submit"><br>

</form>


</body>
</html>
