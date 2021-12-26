package com.company.controller;

import com.company.model.DAO.UserInformationDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.UserInformation;

import java.util.Objects;

public class UserInformationController implements com.company.controller.interfaces.UserInformationController {
    private GeneralDao<UserInformation, Integer> userInformationDao;

    @Override
    public GeneralDao<UserInformation, Integer> generalDao() {
        return Objects.requireNonNullElseGet(userInformationDao,() -> userInformationDao = new UserInformationDao());
    }
}