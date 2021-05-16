package br.com.parkineasy.repository.impl;

import br.com.parkineasy.model.Vaga;
import br.com.parkineasy.model.enums.TipoVaga;
import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.VagaRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaRepositoryImpl implements VagaRepository {

    private final Consulta consulta = new Consulta();

    @Override
    public List<Vaga> listaTodas() {
        ResultSet resultSet = consulta.executaConsulta("SELECT * FROM vaga");


        try {
            List<Vaga> vagas = new ArrayList<>();

            while (resultSet.next()) {
                  Vaga vaga = new Vaga();
                  vaga.setCodigoVaga(resultSet.getString(1));
                  vaga.setSituacaoVaga(resultSet.getInt(2));
                  vaga.setTipoVaga(TipoVaga.values()[resultSet.getInt(3)]);
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return null;
    }

    @Override
    public List<Vaga> listaPorTipo(String tipo) {
        ResultSet resultSet = consulta.executaConsulta("SELECT * FROM vaga WHERE"+tipo+" = tip_vaga");
        try {
            List<Vaga> vagas = new ArrayList<>();
            if(resultSet.next()) {
                Vaga vaga = new Vaga();
                vaga.setCodigoVaga(resultSet.getString(1));
                vaga.setSituacaoVaga(resultSet.getInt(2));
                vaga.setTipoVaga(TipoVaga.values()[resultSet.getInt(3)]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
