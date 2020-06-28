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

public class GetArticleServlet extends HttpServlet {

    private ArticleDAO articleDAO = new ArticleDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Article> articles = articleDAO.getAllArticles();
        req.setAttribute("articles", articles);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/articles.jsp").forward(req, resp);

    }
}
