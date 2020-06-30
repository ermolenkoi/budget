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
    private static final String DELETE = "DELETE FROM budget.article WHERE id=?";
    private static final String INSERT = "INSERT INTO budget.article (name, description) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE budget.article SET name=?, description=? WHERE id=?";

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();// создаем коллекцию Article ( Article - класс обетка, служит для хранения данных id name description)
        try (Connection connection = simpleConnection.getConnection();  // подключаемся к БД
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARTICLE); // передаем запрос в БД
             ResultSet resultSet = preparedStatement.executeQuery()) { // получаем ответ от БЛ
            while (resultSet.next()) { // перебираем итератором, если объект есть входим в цикл
                articles.add(fillArticle(resultSet)); // добавляем данные в коллекцию List
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        return articles; //  возвращем коллекцию объектов
    }

    public Article getArticle(Integer id) {
        try (Connection connection = simpleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTICLE)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return fillArticle(resultSet);
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        return null;
    }

    public void deleteArticle(Integer id) {
        try ( Connection connection = simpleConnection.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex){
            System.out.println("Something went wrong");
        }
    }

    public void addArticle(Article article) {
        if (article != null) {
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                preparedStatement.setString(1, article.getName());
                preparedStatement.setString(2, article.getDescription());
                preparedStatement.executeUpdate();
            } catch (Exception ex){
                System.out.println("Something went wrong");
            }
        }





    }

    public void updateArticle(Article article) {
        if (article != null) {
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
                preparedStatement.setString(1, article.getName());
                preparedStatement.setString(2, article.getDescription());
                preparedStatement.setInt(3, article.getId());
                preparedStatement.executeUpdate();
            } catch (Exception ex){
                System.out.println("Something went wrong");
            }
        }
    }

    private Article fillArticle(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Article(id, name, description);
    }
}
