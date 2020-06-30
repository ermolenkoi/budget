package servlet;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import model.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ArticlesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAOImpl();
        String parameterID = req.getParameter("id");
           if (parameterID != null) {
               Article article = articleDAO.getArticle(Integer.parseInt(parameterID));
               req.setAttribute("article", article);
               getServletContext().getRequestDispatcher("/pages/idArticle.jsp").forward(req, resp);
           } else {
               List<Article> articles = articleDAO.getAllArticles();
               req.setAttribute("articles", articles);
               getServletContext().getRequestDispatcher("/pages/allArticles.jsp").forward(req, resp);
           }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//добавление новой строчки в бд
        ArticleDAO articleDAO = new ArticleDAOImpl();
        String parameterID = req.getParameter("id");
        String parametrArticleName = req.getParameter("name");
        String parametrArticleDesc = req.getParameter("description");
        if (parameterID != null) {
            Article article = new Article(Integer.parseInt(parameterID), parametrArticleName, parametrArticleDesc);
            articleDAO.updateArticle(article);
        } else {
            Article article = new Article(parametrArticleName, parametrArticleDesc);
            articleDAO.addArticle(article);
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //изм
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameterID = req.getParameter("id");
        if (parameterID != null){
            int id = Integer.parseInt(parameterID);
            ArticleDAO articleDAO = new ArticleDAOImpl();
            articleDAO.deleteArticle(id);
        }

    }
}
