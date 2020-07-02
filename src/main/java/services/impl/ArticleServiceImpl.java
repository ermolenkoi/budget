package services.impl;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import model.Article;
import services.ArticleService;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    ArticleDAO articleDAO = new ArticleDAOImpl();


    //получить список всех статей
    @Override
    public List<Article> getAllArticles() {

        return articleDAO.getAllArticles();
    }

    //получить статью
    @Override
    public Article getArticle(Integer id) {
        return articleDAO.getArticle(id);
    }

    //удалить статью по id
    @Override
    public void deleteArticle(Integer id) {

    }

    //добавить статью по id
    @Override
    public int addArticle(Article article) {
        return articleDAO.addArticle(article);
    }

    //обновить статью по id
    @Override
    public int updateArticle(Article article) {
        return articleDAO.updateArticle(article);
    }
}
