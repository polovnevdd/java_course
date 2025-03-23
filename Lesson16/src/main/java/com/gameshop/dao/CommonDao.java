package com.gameshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDao {
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/gameshop";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";

    protected Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
