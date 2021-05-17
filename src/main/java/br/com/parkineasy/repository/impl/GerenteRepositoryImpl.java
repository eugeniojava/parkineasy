package br.com.parkineasy.repository.impl;

import br.com.parkineasy.model.Gerente;
import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.GerenteRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenteRepositoryImpl implements GerenteRepository {

    private final Consulta consulta = new Consulta();
    String name, passw;

    public static void main(String[] args) {
        GerenteRepositoryImpl gerenteRepository = new GerenteRepositoryImpl();
        String nome = "Bruno";
        String pass = "ABC123";
        gerenteRepository.ConsultaGerente(nome, pass);

    }

    @Override
    public List<Gerente> ConsultaGerente(String userName, String senha) {
        ResultSet resultSet = consulta.executaConsulta("select *from gerente where username_gerente ='" + userName +
                "'and password_gerente ='" + senha + "'");
        List<Gerente> gerente = new ArrayList<>();
        try {
            if (resultSet.next()) {
                name = resultSet.getString(3);
                passw = resultSet.getString(4);
                System.out.println(name + passw);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

