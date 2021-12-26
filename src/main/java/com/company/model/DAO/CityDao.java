package com.company.model.DAO;

import com.company.model.models.City;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDao implements com.company.model.DAO.interfaces.CityDao {
    @Override
    public String getAll() {
        return "SELECT * FROM city";
    }

    @Override
    public String getById() {
        return "SELECT * FROM city WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO city(name) VALUES (?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE city SET name=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM city WHERE id=?";
    }


    @Override
    public City recordEntity(ResultSet resultSet) throws SQLException {
        return (City) new Transformer<>(City.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, City model) throws SQLException {
        preparedStatement.setString(1, model.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, City model) throws SQLException {
        preparedStatement.setInt(2, model.getId());
        return preparedStatement;
    }
}