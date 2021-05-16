package br.com.parkineasy.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {

    public ResultSet executaConsulta(String sql) {
        Statement statement = DatabaseConnection.getStatement();

        try {
            return statement.executeQuery(sql);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());

            return null;
        }
    }
}
