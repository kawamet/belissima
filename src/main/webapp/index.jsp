<%@ page import="karolina.controller.LangProvider" %>
<html>
<body>
<h2>To jest strona glowna!</h2>
<h1><%= LangProvider.INSTANCE.getMessage("greetng")%></h1>
<a href="/belissima_war/product.jsp">Add product</a><br>
<a href="/belissima_war/login.jsp">login</a><br>


<div id = flag>
    <a href="/belissima_war/languageServlet?lang=pl">PL</a>
    <a href="/belissima_war/languageServlet?lang=es">es</a>

</div>

</body>
</html>
