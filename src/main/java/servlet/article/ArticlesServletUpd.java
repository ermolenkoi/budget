package servlet.article;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ArticlesServletUpd extends HttpServlet{
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //изм
        ArticleDAO articleDAO = new ArticleDAOImpl();
        String parameterID = req.getParameter("id");
        String parametrArticleName = req.getParameter("name");
        String parametrArticleDesc = req.getParameter("description");
        if (parameterID != null) {
            Article article = new Article(Integer.parseInt(parameterID), parametrArticleName, parametrArticleDesc);
            articleDAO.updateArticle(article);
        }
        resp.sendRedirect(req.getContextPath() + "/readArticles");
        //resp.sendRedirect("readArticles");
    }
}
