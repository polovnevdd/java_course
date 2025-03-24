package com.gameshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDao {
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/gameshop";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";

    Connection connection = null;

    protected Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
}
