package com.company.model.DAO;


public class UserDao implements com.company.model.DAO.interfaces.UserDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("User");
        }
        return queryGenerator;
    }
}