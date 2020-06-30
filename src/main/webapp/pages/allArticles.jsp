<%@ page contentType="text/html;charset=windows-1251" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список статей затрат</title>
</head>
    <body>
    <form action="getArticles" method="GET">
    <h2>Вот все статьи затрат хранящиеся на текущий момент в базе данных</h2>
    <%
        List articles = (List) request.getAttribute("articles");
        for (Object article : articles) {
            %><p><%=article.toString()%></p><%
        }
    %>

    <p>Получить значения по id</p>
            id: <label>
        <input name="id" />
    </label>
        <br><br>
            <input type="submit" value="Submit" />
        </form>


    <form action="getArticles" method="POST">
        <p>Удалить значения по id</p>
        id: <label>
        <input name="id" />
    </label>
        <br><br>
        <input type="submit" value="Delete" />
    </form>


    </body>
</html>