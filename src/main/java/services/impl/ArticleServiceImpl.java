package services.impl;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import model.Article;
import services.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    ArticleDAO articleDAO = new ArticleDAOImpl();

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public Article getArticle(Integer id) {
        return articleDAO.getArticle(id);
    }

    @Override
    public int deleteArticle(Integer id) {
        return articleDAO.deleteArticle(id);
    }

    @Override
    public int addArticle(Article article) {
        return articleDAO.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDAO.updateArticle(article);
    }
}
