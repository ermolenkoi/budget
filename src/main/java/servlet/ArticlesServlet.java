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

    private ArticleDAO articleDAO = new ArticleDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Article article = articleDAO.getArticle(Integer.parseInt(id));
            req.setAttribute("article", article);
            getServletContext().getRequestDispatcher("/pages/articles.jsp").forward(req, resp);
        } else {
            returnAllArticle(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description =req.getParameter("description");
        articleDAO.addArticle(new Article(name, description));
        returnAllArticle(req, resp);
    }

    private void returnAllArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articleDAO.getAllArticles();
        req.setAttribute("articles", articles);
        getServletContext().getRequestDispatcher("/pages/articles.jsp").forward(req, resp);
    }

}
