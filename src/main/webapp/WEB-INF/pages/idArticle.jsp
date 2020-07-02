<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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

    <p><a href="readArticles">Получить все значения БД</a></p>

    </body>
</html>