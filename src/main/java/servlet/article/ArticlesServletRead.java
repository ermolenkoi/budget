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

public class ArticlesServletRead extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAOImpl();
        String parameterID = req.getParameter("id");
           if (parameterID != null) {
               Article article = articleDAO.getArticle(Integer.parseInt(parameterID));
               req.setAttribute("article", article);
               getServletContext().getRequestDispatcher("/WEB-INF/pages/idArticle.jsp").forward(req, resp);
           } else {
               List<Article> articles = articleDAO.getAllArticles();
               req.setAttribute("articles", articles);
               getServletContext().getRequestDispatcher("/WEB-INF/pages/allArticles.jsp").forward(req, resp);
           }
    }






}
