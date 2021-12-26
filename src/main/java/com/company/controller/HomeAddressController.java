package com.company.controller;

import com.company.model.DAO.HomeAddressDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.HomeAddress;

import java.util.Objects;

public class HomeAddressController implements com.company.controller.interfaces.HomeAddressController {
    private GeneralDao<HomeAddress, Integer> homeAddressDao;

    @Override
    public GeneralDao<HomeAddress, Integer> generalDao() {
        return Objects.requireNonNullElseGet(homeAddressDao,() -> homeAddressDao = new HomeAddressDao());
    }

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s |","id","city_id", "number", "street_id");
    }
}