package services;

import model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    Article getArticle(Integer id);

    int deleteArticle(Integer id);

    int addArticle(Article article);

    int updateArticle(Article article);

}
