package com.company.model.DAO;


public class HomeAddressDao implements com.company.model.DAO.interfaces.HomeAddressDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("HomeAddress");
        }
        return queryGenerator;
    }
}