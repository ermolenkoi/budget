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
    public void deleteArticle(Integer id) {
        articleDAO.deleteArticle(id);
    }

    @Override
    public void addArticle(Article article) {
        articleDAO.addArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
         articleDAO.updateArticle(article);
    }
}
