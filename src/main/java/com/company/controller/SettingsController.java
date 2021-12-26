package com.company.controller;

import com.company.model.DAO.SettingsDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.Settings;

import java.util.Objects;

public class SettingsController implements com.company.controller.interfaces.SettingsController {
    private GeneralDao<Settings, Integer> settingsDao;

    @Override
    public GeneralDao<Settings, Integer> generalDao() {
        return Objects.requireNonNullElseGet(settingsDao,() -> settingsDao = new SettingsDao());
    }
}