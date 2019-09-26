<%@ page import="karolina.controller.LangProvider" %>



<html>
<body>
<h2>To jest strona glowna!</h2>
<h1><%= LangProvider.INSTANCE.getMessage("greetng")%>
</h1>
<a href="/belissima_war/product.jsp">Add product</a><br>
<a href="/belissima_war/login.jsp">Login</a><br>
<a href="/belissima_war/allproducts.jsp">See all products</a><br>



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
