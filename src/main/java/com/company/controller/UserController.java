package com.company.controller;

import com.company.model.DAO.UserDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.User;

import java.util.Objects;

public class UserController implements com.company.controller.interfaces.UserController {
    private GeneralDao<User, Integer> userDao;

    @Override
    public GeneralDao<User, Integer> generalDao() {
        return Objects.requireNonNullElseGet(userDao,() -> userDao = new UserDao());
    }

    public String printColumns(){
        return String.format("|%3s| %-20s |","User_id","home_address_id");
    }
}