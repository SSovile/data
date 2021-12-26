package com.company.controller;

import com.company.model.DAO.StreetDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.Street;

import java.util.Objects;

public class StreetController implements com.company.controller.interfaces.StreetController {
    private GeneralDao<Street, Integer> streetDao;

    @Override
    public GeneralDao<Street, Integer> generalDao() {
        return Objects.requireNonNullElseGet(streetDao,() -> streetDao = new streetDao());
    }
}