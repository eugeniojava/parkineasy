package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservaRepositoryImpl implements ReservaRepository {

    private final Consulta consulta = new Consulta();

    @Override
    public Boolean cadastraReserva(String codigoVaga) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter dataHoraFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = agora.format(dataHoraFormato);
        System.out.println(dataHoraFormatada);
        System.out.println(codigoVaga);
        Integer resultSet1 = consulta.executaAtualizacao("insert into reserva (data_hora_entrada) values ('" + dataHoraFormatada + "')");
        Integer resultSet2 = consulta.executaAtualizacao("insert into pagamento() values();");
        Integer resultSet3 = consulta.executaAtualizacao("insert into uso(id_reserva,id_vaga,data_hora_entrada) select id_reserva,\""+codigoVaga+"\",data_hora_entrada from reserva where data_hora_entrada = '"+dataHoraFormatada+"';");
        Integer resultSet4 = consulta.executaAtualizacao("update uso set id_pagamento = id_reserva  where data_hora_entrada = '"+dataHoraFormatada+"' ;");
        Integer resultSet5 = consulta.executaAtualizacao("update vaga set sit_vaga = 1 where id_vaga = \""+codigoVaga+"\";");
        //System.out.println(resultSet1);

        return (resultSet1 + resultSet2 + resultSet3 + resultSet4 + resultSet5) == 5 ? true : false;
    }

    public static void main(String[] args) {
        var repository = new ReservaRepositoryImpl();
        repository.cadastraReserva("C08");
    }
}
