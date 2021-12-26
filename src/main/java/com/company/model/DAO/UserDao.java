package com.company.model.DAO;

import com.company.model.models.User;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements com.company.model.DAO.interfaces.UserDao {
    @Override
    public String getAll() {
        return "SELECT * FROM user";
    }

    @Override
    public String getById() {
        return "SELECT * FROM user WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO user(nickname) VALUES (?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE user SET nickname=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM user WHERE id=?";
    }


    @Override
    public User recordEntity(ResultSet resultSet) throws SQLException {
        return (User) new Transformer<>(User.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, User model) throws SQLException {
        preparedStatement.setString(1, model.getNickname());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, User model) throws SQLException {
        preparedStatement.setInt(2, model.getId());
        return preparedStatement;
    }
}