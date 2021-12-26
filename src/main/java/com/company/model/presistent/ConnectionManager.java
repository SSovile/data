package com.company.model.presistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private final static String url = "jdbc:mysql://localhost:3306/watchs";
    private final static String root = "root";
    private final static String pass = "root";
    private static Connection connection = null;

    public static Connection setConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, root, pass);
            } catch (SQLException e) {
                System.out.println("SQL Exception:" + e.getMessage());
                System.out.println("SQL State:" + e.getSQLState());
                System.out.println("Vendor Error:" + e.getErrorCode());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("SQL Exception:" + e.getMessage());
                System.out.println("SQL State:" + e.getSQLState());
                System.out.println("Vendor Error:" + e.getErrorCode());
            }
        }
    }


}