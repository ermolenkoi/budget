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

public class DeleteArticleServlet extends HttpServlet {

    private ArticleDAO articleDAO = new ArticleDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        articleDAO.deleteArticle(id);
    }
}
