package com.company.model.DAO;

import com.company.model.models.UserInformation;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInformationDao implements com.company.model.DAO.interfaces.UserInformationDao {
    @Override
    public String getAll() {
        return "SELECT * FROM userInformation";
    }

    @Override
    public String getById() {
        return "SELECT * FROM userInformation WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO userInformation(position_id, palpitation) VALUES (?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE userInformation SET position_id=?, palpitation=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM userInformation WHERE id=?";
    }


    @Override
    public UserInformation recordEntity(ResultSet resultSet) throws SQLException {
        return (UserInformation) new Transformer<>(UserInformation.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, UserInformation model) throws SQLException {
        preparedStatement.setInt(1, model.getPositionId());
        preparedStatement.setFloat(2, model.getPalpitation());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, UserInformation model) throws SQLException {
        preparedStatement.setInt(3, model.getId());
        return preparedStatement;
    }
}