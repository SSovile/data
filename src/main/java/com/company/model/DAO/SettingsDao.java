package com.company.model.DAO;


public class SettingsDao implements com.company.model.DAO.interfaces.SettingsDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Settings");
        }
        return queryGenerator;
    }
}