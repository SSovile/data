package com.company.controller;

import com.company.model.DAO.PositionDao;
import com.company.model.DAO.interfaces.GeneralDao;
import com.company.model.models.Position;

import java.util.Objects;

public class PositionController implements com.company.controller.interfaces.PositionController {
    private GeneralDao<Position, Integer> positionDao;

    @Override
    public GeneralDao<Position, Integer> generalDao() {
        return Objects.requireNonNullElseGet(positionDao,() -> positionDao = new PositionDao());
    }
}