<%@ page contentType="text/html;charset=windows-1251" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список статей затрат</title>
</head>
    <body>
    <h2>Вот все статьи затрат хранящиеся на текущий момент в базе данных</h2>
    <%
        List articles = (List) request.getAttribute("articles");
        for (Object article : articles) {
            %><p><%=article.toString()%></p><%
        }
    %>
    </body>
</html>