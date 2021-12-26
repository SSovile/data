package com.company.model.DAO;


public class PositionDao implements com.company.model.DAO.interfaces.PositionDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Position");
        }
        return queryGenerator;
    }
}