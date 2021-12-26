package com.company.model.DAO;

import com.company.model.models.Customer;
import com.company.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao implements com.company.model.DAO.interfaces.CustomerDao {
    @Override
    public String getAll() {
        return "SELECT * FROM customer";
    }

    @Override
    public String getById() {
        return "SELECT * FROM customer WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO customer(firstname, lastname, email) VALUES (?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE customer SET firstname=?, lastname=?, email=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM customer WHERE id=?";
    }


    @Override
    public Customer recordEntity(ResultSet resultSet) throws SQLException {
        return (Customer) new Transformer<>(Customer.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Customer model) throws SQLException {
        preparedStatement.setString(1, model.getFirstName());
        preparedStatement.setString(2, model.getLastName());
        preparedStatement.setString(3, model.getEmail());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Customer model) throws SQLException {
        preparedStatement.setInt(4, model.getId());
        return preparedStatement;
    }
}