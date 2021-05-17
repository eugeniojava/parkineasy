package br.com.parkineasy.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {

    // retorna o numero de linhas afetadas
    // executa insert, update e delete
    public Integer executaAtualizacao(String sql) {
        Statement statement = Conexao.getStatement();

        try {
            return statement.executeUpdate(sql);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());

            return null;
        }
    }

    // retorna um objeto ResultSet
    // executa select
    public ResultSet executaConsulta(String sql) {
        Statement statement = Conexao.getStatement();

        try {
            return statement.executeQuery(sql);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());

            return null;
        }
    }
}
