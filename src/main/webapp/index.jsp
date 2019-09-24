<%@ page import="karolina.controller.LangProvider" %>
<%--
<style><%@include file="/WEB-INF/css/style.css"%></style>
--%>

<html>
<body>
<h2>To jest strona glowna!</h2>
<h1><%= LangProvider.INSTANCE.getMessage("greetng")%>
</h1>
<a href="/belissima_war/product.jsp">Add product</a><br>
<a href="/belissima_war/login.jsp">Login</a><br>

<button></button>

<div id=flag>
    <a href="/belissima_war/languageServlet?lang=pl">PL</a>
    <a href="/belissima_war/languageServlet?lang=en">EN</a>
</div>

<div id="style">
    <button onclick="myFunction1()">BLUE</button>
    <button onclick="myFunction2()">GREEN</button>

</div>
<script>
    function myFunction1() {
        document.body.style.background = 'blue';
    }

    function myFunction2() {
        document.body.style.background = 'green';
    }

</script>


</body>
</html>
