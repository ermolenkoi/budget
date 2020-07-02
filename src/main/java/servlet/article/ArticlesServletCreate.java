package servlet.article;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ArticlesServletCreate extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//добавление новой строчки в бд
        ArticleDAO articleDAO = new ArticleDAOImpl();
        String parametrArticleName = req.getParameter("name");
        String parametrArticleDesc = req.getParameter("description");
        Article article = new Article(parametrArticleName, parametrArticleDesc);
        articleDAO.addArticle(article);
        //resp.sendRedirect("readArticles");
        resp.sendRedirect(req.getContextPath() + "/readArticles");



    }
}
