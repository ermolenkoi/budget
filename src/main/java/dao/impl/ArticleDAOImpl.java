package dao.impl;

import dao.ArticleDAO;
import dao.BasicDAO;
import model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl extends BasicDAO implements ArticleDAO {

    private static final String SELECT_ALL_ARTICLE = "SELECT id, name, description FROM budget.article";
    private static final String SELECT_ARTICLE = "SELECT id, name, description FROM budget.article WHERE id=?";
    private static final String DELETE_ARTICLE = "DELETE FROM budget.article WHERE id=?";
    private static final String INSERT_ARTICLE = "INSERT INTO budget.article(name, description) VALUES (?, ?)";
    private static final String UPDATE_ARTICLE = "UPDATE budget.article SET name=?, description=? WHERE id=?";

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = simpleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARTICLE);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                articles.add(fillArticle(resultSet));
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        return articles;
    }

    public Article getArticle(Integer id) {
        try (Connection connection = simpleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTICLE);
             ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (fillArticle(resultSet));
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        return null;
    }

    public int deleteArticle(Integer id) {
        try (Connection connection = simpleConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(DELETE_ARTICLE)) {
            pst.setInt(1, id);
            return pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        return 0;
    }

    public int addArticle(Article article) {
        if (article != null) {
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(INSERT_ARTICLE)) {
                pst.setString(1, article.getName());
                pst.setString(2, article.getDescription());
                return pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Something went wrong");
            }
        }
        return 0;
    }

    public int updateArticle(Article article) {
        if (article != null) {
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(UPDATE_ARTICLE)) {
                pst.setString(1, article.getName());
                pst.setString(2, article.getDescription());
                pst.setInt(3, article.getId());
                return pst.executeUpdate();
            } catch (Exception ex) {
                System.out.println("Something went wrong");
            }
        }
        return 0;
    }

    private Article fillArticle(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Article(id, name, description);
    }
}
