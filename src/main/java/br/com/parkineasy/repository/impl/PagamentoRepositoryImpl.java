package br.com.parkineasy.repository.impl;

import br.com.parkineasy.model.ComprovantePagamento;
import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.PagamentoRepository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class PagamentoRepositoryImpl implements PagamentoRepository {

    private final Consulta consulta = new Consulta();

    public Boolean salvar(Integer codigoTicket, Integer metodoPagamento, BigDecimal valorTotal) {
        DateTimeFormatter dataHoraFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = LocalDateTime.now().format(dataHoraFormato);
        Integer consultasASeremRealizadas = 3;
        Integer consultasComSucesso = 0;
        Random random = new Random();
        int comprovante = random.nextInt(1000);

        consultasComSucesso = consulta.executarAtualizacao(
                "UPDATE pagamento SET data_hora_pagamento = '" + dataHoraFormatada + "'," +
                        " met_pagamento = " + metodoPagamento + "" +
                        " WHERE id_pagamento = " + codigoTicket + "");
        consultasComSucesso += consulta.executarAtualizacao(
                "UPDATE uso SET data_hora_pagamento = (SELECT data_hora_pagamento FROM pagamento" +
                        " WHERE id_pagamento = " + codigoTicket + "), data_hora_total =" +
                        " timediff(data_hora_pagamento, data_hora_entrada), valor_pago = " + valorTotal + " WHERE " +
                        "id_reserva = " + codigoTicket);
        consultasComSucesso += consulta.executarAtualizacao(
                "UPDATE pagamento SET comprovante_pagamento = " + comprovante + " where id_pagamento = " + codigoTicket);

        return consultasComSucesso.equals(consultasASeremRealizadas);
    }

    public ComprovantePagamento mostraComprovante(Integer codigoTicket) {
        ResultSet resultSet = consulta.executarConsulta("select comprovante_pagamento from pagamento " +
                "where id_pagamento =" + codigoTicket);

        try {
            if (resultSet.next()) {
                ComprovantePagamento comprovante = new ComprovantePagamento();
                comprovante.setComprovantePagamento(resultSet.getInt("comprovante_pagamento"));
                return comprovante;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public Boolean conferirComprovanteDePagamento(Integer comprovanteSaida) {
        ResultSet resultSet = consulta.executarConsulta(
                "SELECT * FROM pagamento WHERE comprovante_pagamento = " + comprovanteSaida);

        try {
            if (resultSet.next()) {
                Integer result = consulta.executarAtualizacao(
                        "UPDATE vaga SET sit_vaga = 0 WHERE id_vaga = " +
                                "(SELECT id_vaga FROM uso WHERE id_pagamento = (SELECT id_pagamento FROM pagamento " +
                                "WHERE comprovante_pagamento = " + comprovanteSaida + "))");

                return result == 1;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }
}