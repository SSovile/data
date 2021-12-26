package com.company.model.DAO;


public class CustomerDao implements com.company.model.DAO.interfaces.CustomerDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Customer");
        }
        return queryGenerator;
    }
}