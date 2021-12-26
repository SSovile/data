package com.company.controller;

import com.company.model.DAO.CustomerDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.Customer;

import java.util.Objects;

public class CustomerController implements com.company.controller.interfaces.CustomerController {
    private GeneralDao<Customer, Integer> customerDao;

    @Override
    public GeneralDao<Customer, Integer> generalDao() {
        return Objects.requireNonNullElseGet(customerDao,() -> customerDao = new CustomerDao());
    }
}