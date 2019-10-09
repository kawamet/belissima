<%@ page import="karolina.controller.LangProvider" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<%--<h1><%= LangProvider.INSTANCE.getMessage("greetng")%>--%>
</h1>
<a href="/belissima_war/product.jsp"><%= LangProvider.INSTANCE.getMessage("addproduct")%></a><br>
<a href="/belissima_war/login.jsp"><%= LangProvider.INSTANCE.getMessage("login")%></a><br>
<a href="/belissima_war/product"><%= LangProvider.INSTANCE.getMessage("allproducts")%></a><br>
<a href="/belissima_war/productid.jsp"><%= LangProvider.INSTANCE.getMessage("findproduct")%></a><br>



<a href="/belissima_war/languageServlet?lang=pl" name="lang_pl">PL</a>
<a href="/belissima_war/languageServlet?lang=en" name="lang_en">EN</a>



<script>
    function myFunction1() {
        document.body.style.fontSize = '20px';
    }

    function myFunction2() {
        document.body.style.fontSize = '25px';
    }

</script>


</body>
</html>
