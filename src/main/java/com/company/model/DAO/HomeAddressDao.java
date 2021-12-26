package com.company.model.DAO;

import com.company.model.models.HomeAddress;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeAddressDao implements com.company.model.DAO.interfaces.HomeAddressDao {
    @Override
    public String getAll() {
        return "SELECT * FROM homeAddress";
    }

    @Override
    public String getById() {
        return "SELECT * FROM homeAddress WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO homeAddress(city_id, number, street_id) VALUES (?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE homeAddress SET city_id=?, number=?, street_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM homeAddress WHERE id=?";
    }


    @Override
    public HomeAddress recordEntity(ResultSet resultSet) throws SQLException {
        return (HomeAddress) new Transformer<>(HomeAddress.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, HomeAddress model) throws SQLException {
        preparedStatement.setInt(1, model.getCityId());
        preparedStatement.setInt(2, model.getNumber());
        preparedStatement.setInt(3, model.getStreetId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, HomeAddress model) throws SQLException {
        preparedStatement.setInt(4, model.getId());
        return preparedStatement;
    }
}