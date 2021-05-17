package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.PagamentoRepository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PagamentoRepositoryImpl implements PagamentoRepository {

    private final Consulta consulta = new Consulta();

    public Boolean efetuarPagamento(Integer codigoTicket, Integer pagamento){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter dataHoraFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = agora.format(dataHoraFormato);
        CalcularValor(dataHoraFormatada);
        Integer resultSet = consulta.executaAtualizacao("update pagamento set data_hora_pagamento = '"+dataHoraFormatada+"', met_pagamento ="+pagamento+" where id_pagamento = "+codigoTicket+";");
        Integer resultSet1 =consulta.executaAtualizacao("update uso set data_hora_pagamento = (select data_hora_pagamento from pagamento where id_pagamento = "+codigoTicket+"),data_hora_total = timediff(data_hora_pagamento,data_hora_entrada) where id_reserva = "+codigoTicket+";");
        Integer resultSet2 = consulta.executaAtualizacao("update vaga set sit_vaga = 0 where id_vaga = (select id_vaga from uso where id_reserva="+codigoTicket+");");
        System.out.println(resultSet);
        return (resultSet + resultSet1 + resultSet2) == 3 ? true : false;
    }

    public Float CalcularValor(String datadopagamento, Integer codigoTicket){
        float valortotal = 10;
        ResultSet resultSet = consulta.executaConsulta("select timediff('"+datadopagamento+"',uso.data_hora_entrada) from uso where id_reserva = "+codigoTicket+";");
        System.out.println(resultSet);
        return valortotal;
    }

    public static void main(String[] args) {
        var repository = new PagamentoRepositoryImpl();
        repository.efetuarPagamento(44,1);
    }
}
