package com.company.model.DAO;


public class SmartWatchDao implements com.company.model.DAO.interfaces.SmartWatchDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("SmartWatch");
        }
        return queryGenerator;
    }
}