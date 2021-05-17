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

    public static void main(String[] args) {
        VagaRepositoryImpl vagaRepository = new VagaRepositoryImpl();

        //vagaRepository.listaTodas();
        vagaRepository.listaPorTipo(1);
    }

    @Override
    public List<Vaga> listaTodas() {
        ResultSet resultSet = consulta.executaConsulta("SELECT * FROM vaga");
        List<Vaga> vagas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Vaga vaga = new Vaga();

                vaga.setCodigoVaga(resultSet.getString("id_vaga"));
                vaga.setSituacaoVaga(resultSet.getInt("sit_vaga"));
                vaga.setTipoVaga(TipoVaga.values()[resultSet.getInt("tip_vaga") - 1]);

                vagas.add(vaga);
            }
            vagas.forEach(System.out::println);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return null;
    }

    @Override
    public List<Vaga> listaPorTipo(Integer tipo) {
        ResultSet resultSet = consulta.executaConsulta("SELECT * FROM vaga WHERE tip_vaga ='" + tipo+"' and sit_vaga = 0");
        List<Vaga> vagas = new ArrayList<>();
        try {

            while (resultSet.next()) {
                Vaga vaga = new Vaga();

                vaga.setCodigoVaga(resultSet.getString("id_vaga"));
                vaga.setSituacaoVaga(resultSet.getInt("sit_vaga"));
                vaga.setTipoVaga(TipoVaga.values()[resultSet.getInt("tip_vaga") - 1]);

                vagas.add(vaga);
            }
            vagas.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
