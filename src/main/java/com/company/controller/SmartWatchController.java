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

    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |","id","model", "Customer_id", "Charge", "user_id");
    }
}