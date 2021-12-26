package com.company.model.DAO;

import com.company.model.models.Position;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionDao  implements com.company.model.DAO.interfaces.PositionDao{
    @Override
    public String getAll() {
        return "SELECT * FROM position";
    }

    @Override
    public String getById() {
        return "SELECT * FROM position WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO position(length, width) VALUES (?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE position SET length=?, width=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM position WHERE id=?";
    }

    @Override
    public Position recordEntity(ResultSet resultSet) throws SQLException {
        return (Position) new Transformer<>(Position.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Position model) throws SQLException {
        preparedStatement.setString(1, model.getLength());
        preparedStatement.setString(2, model.getWidth());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Position model) throws SQLException {
        preparedStatement.setInt(3, model.getId());
        return preparedStatement;
    }
}