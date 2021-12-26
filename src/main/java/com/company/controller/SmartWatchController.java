package com.company.controller;

import com.company.model.DAO.SmartWatchDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.SmartWatch;

import java.util.Objects;

public class SmartWatchController implements com.company.controller.interfaces.SmartWatchController {
    private GeneralDao<SmartWatch, Integer> smartWatchDao;

    @Override
    public GeneralDao<SmartWatch, Integer> generalDao() {
        return Objects.requireNonNullElseGet(smartWatchDao,() -> smartWatchDao = new SmartWatchDao());
    }
}