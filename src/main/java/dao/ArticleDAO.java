package dao;

import model.Article;

import java.util.List;

public interface ArticleDAO {

    List<Article> getAllArticles();

    Article getArticle(Integer id);

    void deleteArticle(Integer id);

    void addArticle(Article article);

    void updateArticle(Article article);

}
