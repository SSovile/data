package com.company.model.DAO;

import com.company.model.models.SmartWatch;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SmartWatchDao implements com.company.model.DAO.interfaces.SmartWatchDao {
    @Override
    public String getAll() {
        return "SELECT * FROM smartWatch";
    }

    @Override
    public String getById() {
        return "SELECT * FROM smartWatch WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO smartWatch(model, customer_id, charge, user_id) VALUES (?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE smartWatch SET model=?, customer_id=?, charge=?, user_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM smartWatch WHERE id=?";
    }


    @Override
    public SmartWatch recordEntity(ResultSet resultSet) throws SQLException {
        return (SmartWatch) new Transformer<>(SmartWatch.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, SmartWatch model) throws SQLException {
        preparedStatement.setString(1, model.getModel());
        preparedStatement.setString(2, model.getCustomerId());
        preparedStatement.setString(3, model.getCharge());
        preparedStatement.setString(4, model.getUserId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, SmartWatch model) throws SQLException {
        preparedStatement.setInt(5, model.getId());
        return preparedStatement;
    }
}