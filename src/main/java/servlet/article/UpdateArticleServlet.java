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

public class UpdateArticleServlet extends HttpServlet {

    private ArticleDAO articleDAO = new ArticleDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        articleDAO.updateArticle(new Article(id, name, description));
        /*List<Article> articles = articleDAO.getAllArticles();
        req.setAttribute("articles", articles);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/articles.jsp").forward(req, resp);*/
        //req.getRequestDispatcher("/articles").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/articles");
    }
}
