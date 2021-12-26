package com.company.model.DAO;


public class CityDao implements com.company.model.DAO.interfaces.CityDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("City");
        }
        return queryGenerator;
    }
}