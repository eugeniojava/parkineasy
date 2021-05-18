package br.com.parkineasy.repository.impl;

import br.com.parkineasy.model.Relatorio;
import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.GerenteRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenteRepositoryImpl implements GerenteRepository {

    private final Consulta consulta = new Consulta();

    @Override
    public Boolean validarGerente(String username, String senha) {
        ResultSet resultSet = consulta.executarConsulta(
                "SELECT * FROM gerente" +
                        " WHERE username_gerente = '" + username + "' AND password_gerente = '" + senha + "'");

        try {
            return resultSet.next();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());

            return false;
        }
    }

    @Override
    public List<Relatorio> gerarRelatorio(LocalDate data) {
        ResultSet resultSet = consulta.executarConsulta(
                "SELECT * FROM uso WHERE date(data_hora_saida) = '" + data + "'");
        List<Relatorio> relatorios = new ArrayList<>();
        DateTimeFormatter dataHoraFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            while (resultSet.next()) {
                Relatorio relatorio = new Relatorio();

                relatorio.setCodigoTicket(resultSet.getInt("id_reserva"));
                relatorio.setCodigoVaga(resultSet.getString("id_vaga"));
                relatorio.setCodigoComprovante(resultSet.getInt("id_pagamento"));
                relatorio.setDataHoraEntrada(LocalDateTime.parse(resultSet.getString("data_hora_entrada"),
                        dataHoraFormato));
                relatorio.setDataHoraSaida(LocalDateTime.parse(resultSet.getString("data_hora_saida"),
                        dataHoraFormato));
                relatorio.setDataHoraPagamento(LocalDateTime.parse(resultSet.getString("data_hora_pagamento"),
                        dataHoraFormato));
                relatorio.setTotalHoras(resultSet.getTime("data_hora_total").toLocalTime());
                relatorio.setValorPago(resultSet.getBigDecimal("valor_pago"));

                relatorios.add(relatorio);
            }

            return relatorios;
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());

            return null;
        }
    }
}

