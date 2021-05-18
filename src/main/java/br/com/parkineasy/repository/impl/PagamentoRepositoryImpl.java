package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.PagamentoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PagamentoRepositoryImpl implements PagamentoRepository {

    private final Consulta consulta = new Consulta();

    public Boolean salvar(Integer codigoTicket, Integer metodoPagamento) {
        DateTimeFormatter dataHoraFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = LocalDateTime.now().format(dataHoraFormato);
        Integer consultasASeremRealizadas = 3;
        Integer atualizacoesComSucesso = 0;

        atualizacoesComSucesso = consulta.executarAtualizacao(
                "UPDATE pagamento SET data_hora_pagamento = '" + dataHoraFormatada + "'," +
                        " met_pagamento = " + metodoPagamento + "" +
                        " WHERE id_pagamento = " + codigoTicket + "");
        atualizacoesComSucesso += consulta.executarAtualizacao(
                "UPDATE uso SET data_hora_pagamento = (SELECT data_hora_pagamento FROM pagamento" +
                        " WHERE id_pagamento = " + codigoTicket + "), data_hora_total =" +
                        " timediff(data_hora_pagamento, data_hora_entrada) WHERE id_reserva = " + codigoTicket);
        atualizacoesComSucesso += consulta.executarAtualizacao(
                "UPDATE vaga SET sit_vaga = 0 WHERE id_vaga =" +
                        " (SELECT id_vaga FROM uso WHERE id_reserva = " + codigoTicket + ")");

        return atualizacoesComSucesso.equals(consultasASeremRealizadas);
    }
}
