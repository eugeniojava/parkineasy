package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservaRepositoryImpl implements ReservaRepository {

    private final Consulta consulta = new Consulta();

    @Override
    public Boolean salvar(String codigoVaga) {
        DateTimeFormatter dataHoraFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = LocalDateTime.now().format(dataHoraFormato);
        Integer consultasASeremRealizadas = 5;
        Integer atualizacoesComSucesso = 0;

        atualizacoesComSucesso = consulta.executarAtualizacao(
                "INSERT INTO reserva(data_hora_entrada) VALUES ('" + dataHoraFormatada + "')");
        atualizacoesComSucesso += consulta.executarAtualizacao("INSERT INTO pagamento() VALUES ()");
        atualizacoesComSucesso += consulta.executarAtualizacao(
                "INSERT INTO uso(id_reserva, id_vaga, data_hora_entrada)" +
                        " SELECT id_reserva, \"" + codigoVaga + "\", data_hora_entrada FROM reserva" +
                        " WHERE data_hora_entrada = '" + dataHoraFormatada + "'");
        atualizacoesComSucesso += consulta.executarAtualizacao(
                "UPDATE uso SET id_pagamento = id_reserva WHERE data_hora_entrada = '" + dataHoraFormatada + "'");
        atualizacoesComSucesso += consulta.executarAtualizacao(
                "UPDATE vaga SET sit_vaga = 1 WHERE id_vaga = \"" + codigoVaga + "\"");

        return atualizacoesComSucesso.equals(consultasASeremRealizadas);
    }
}
