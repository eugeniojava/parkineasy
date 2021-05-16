package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.VagaRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VagaRepositoryImpl implements VagaRepository {

    private final Consulta consulta = new Consulta();

    @Override
    public List<Vaga> listaTodas() {
        ResultSet resultSet = consulta.executaConsulta("SELECT * FROM vaga");

        try {
            List<Vaga> vagas = new ArrayList<>();

            while (resultSet.next()) {
                vagas.add
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }


        return null;
    }

    @Override
    public Lista<Vaga> listaPorTipo(String tipo) {
        return null;
    }
}
