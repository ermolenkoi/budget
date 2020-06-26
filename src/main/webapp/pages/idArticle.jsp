<%@ page contentType="text/html;charset=windows-1251" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Article" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список статей затрат</title>
</head>
    <body>

    <h2>Затраты с конкретным id</h2>

    <%
        Article article = (Article) request.getAttribute("article");
    %>

            <p><%=article.toString()%></p>
    </body>
</html>