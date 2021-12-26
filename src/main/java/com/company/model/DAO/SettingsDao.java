package com.company.model.DAO;

import com.company.model.models.Settings;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SettingsDao implements com.company.model.DAO.interfaces.SettingsDao {
    @Override
    public String getAll() {
        return "SELECT * FROM settings";
    }

    @Override
    public String getById() {
        return "SELECT * FROM settings WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO settings(home_address) VALUES (?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE settings SET home_address=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM settings WHERE id=?";
    }


    @Override
    public Settings recordEntity(ResultSet resultSet) throws SQLException {
        return (Settings) new Transformer<>(Settings.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Settings model) throws SQLException {
        preparedStatement.setInt(1, model.getHomId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Settings model) throws SQLException {
        preparedStatement.setInt(2, model.getUserId());
        return preparedStatement;
    }
}