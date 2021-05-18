package br.com.parkineasy.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/parkineasy";
    private static final String USER = "root";
    private static final String PASSWORD = "root1999";
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }

    public static Statement getStatement() {
        return statement;
    }
}
