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
        List<Article> articles = articleDAO.getAllArticles();

        req.setAttribute("articles", articles);

        getServletContext().getRequestDispatcher("/pages/allArticles.jsp").forward(req, resp);
    }

}
