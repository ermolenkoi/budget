<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Article" %>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
        <title>Список статей затрат</title>
        <script type="text/javascript"><%@include file="../../js/httpService.js"%></script>
    </head>
    <body>
    <%
        List articles = (List) request.getAttribute("articles");
        Article article = (Article) request.getAttribute("article");
        if (articles != null) {
            %><h2>Вот все статьи затрат хранящиеся на текущий момент в базе данных</h2><%
            for (Object item : articles) {
                Article articleEach = (Article)item;
                %><form id="article<%=articleEach.getId()%>"
                        action="articles/update"
                        method="post"
                        accept-charset="UTF-8">

                    <input name="id" type="text" value="<%=articleEach.getId()%>">
                    <input name="name" type="text" value="<%=articleEach.getName()%>">
                    <input name="description" type="text" value="<%=articleEach.getDescription()%>">
                    <input type="button" value="Удалить" onclick="deleteArticle(<%=articleEach.getId()%>)">
                    <input type="submit" value="Изменить">
                </form><%
            }
        }
        if (article != null) {
            %><h2>cтатья затрат с id = <%=article.getId()%></h2><%
            %><p><%=article.toString()%></p><%
        }
    %>
    <form name="newArticle" action="articles/add" method="post" accept-charset="UTF-8">
        <input name="name" type="text">
        <input name="description" type="text">
        <input type="submit">
    </form>
    </body>
</html>