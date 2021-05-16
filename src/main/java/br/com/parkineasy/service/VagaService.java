package br.com.parkineasy.service;

import br.com.parkineasy.repository.Consulta;

import java.sql.ResultSet;

public class VagaService {

    private final Consulta consulta = new Consulta();

    public List<Vaga> listarTodasVagas() {
        ResultSet resultSet = consulta.executaConsulta("SELECT * FROM vaga");

        while (resultSet.next()) {

        }
    }
}
