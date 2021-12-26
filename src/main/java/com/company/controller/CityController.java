package com.company.controller;

import com.company.model.DAO.CityDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.City;

import java.util.Objects;

public class CityController implements com.company.controller.interfaces.CityController {
    private GeneralDao<City, Integer> сityDao;

    @Override
    public GeneralDao<City, Integer> generalDao() {
        return Objects.requireNonNullElseGet(cityDao,() -> cityDao = new CityDao());
    }
    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s |","id", "name");
    }
}