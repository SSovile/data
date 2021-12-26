package com.company.model.DAO;


public class UserInformationDao implements com.company.model.DAO.interfaces.UserInformationDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("UserInformation");
        }
        return queryGenerator;
    }
}