//package br.com.parkineasy.repository;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Optional;
//
//public class DatabaseConnection {
//
//    private final String DB_URL = "jdbc:mysql://localhost:3306/parkineasy";
//    private final String DB_USER = "root";
//    private final String DB_PASSWORD = "root1999";
//
//    private Connection getConexao() {
//        try {
//            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//
//            return connection;
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//
//            return null;
//        }
//    }
//        try
//
//    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println("Conxão realizada com sucesso na URL:" + url);
//        String query = "Insert into gerente(id_gerente,nome_gerente,username_gerente,password_gerente) values(2," +
//                "'Marcão','marcosMK12','ABC123')";
//        Statement statement = connection.createStatement();
//        statement.execute(query);
//
//    } catch(
//    ClassNotFoundException e)
//
//    {
//        e.printStackTrace();
//    } catch(
//    SQLException throwables)
//
//    {
//        throwables.printStackTrace();
//    }
//
//    public Vaga realizaConsulta(String query) {
//        Optional<Connection> optionalConexao = getConexao();
//
//        if (optionalConexao.isPresent()) {
//
//        }
//    }
//}
