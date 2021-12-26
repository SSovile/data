package com.company.model.DAO;


public class StreetDao implements com.company.model.DAO.interfaces.StreetDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Street");
        }
        return queryGenerator;
    }
}