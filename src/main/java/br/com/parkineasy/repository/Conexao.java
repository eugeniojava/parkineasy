package br.com.parkineasy.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    public static void main(String args[]) {;
        String url = "jdbc:mysql://localhost:3306/parkineasy";
        String user = "root";
        String password = "root1999";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,user,password);
            System.out.println("Conxão realizada com sucesso na URL:" + url);
            String query ="Insert into gerente(id_gerente,nome_gerente,username_gerente,password_gerente) values(2,'Marcão','marcosMK12','ABC123')";
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
