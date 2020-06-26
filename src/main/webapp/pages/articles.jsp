<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Article" %>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
        <title>Список статей затрат</title>
        <script type="text/javascript"><%@include file="../WEB-INF/js/httpService.js"%></script>
        <script>
                alert( 'Всем привет!' );
        </script>
    </head>
    <body>
    <%
        List articles = (List) request.getAttribute("articles");
        Article article = (Article) request.getAttribute("article");
        if (articles != null) {
            %><h2>Вот все статьи затрат хранящиеся на текущий момент в базе данных</h2><%
            for (Object item : articles) {
                %><div><span><%=item.toString()%></span><button onclick="bbb()">Удалить</button></div><%
            }
        }
        if (article != null) {
            %><h2>cтатья затрат с id = <%=article.getId()%></h2><%
            %><p><%=article.toString()%></p><%
        }
    %>
    <form method="post" accept-charset="UTF-8">
        <input name="name" type="text">
        <input name="description" type="text">
        <input type="submit">
    </form>
    </body>
</html>