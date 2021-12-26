package com.company.model.DAO;

import com.company.model.models.Street;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetDao implements com.company.model.DAO.interfaces.StreetDao {
    @Override
    public String getAll() {
        return "SELECT * FROM street";
    }

    @Override
    public String getById() {
        return "SELECT * FROM street WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO street(name) VALUES (?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE street SET name=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM street WHERE id=?";
    }


    @Override
    public Street recordEntity(ResultSet resultSet) throws SQLException {
        return (Street) new Transformer<>(Street.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Street model) throws SQLException {
        preparedStatement.setString(1, model.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Street model) throws SQLException {
        preparedStatement.setInt(2, model.getId());
        return preparedStatement;
    }
}