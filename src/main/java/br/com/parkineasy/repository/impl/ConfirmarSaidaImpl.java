package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.ConfirmarSaida;
import br.com.parkineasy.repository.Consulta;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfirmarSaidaImpl implements ConfirmarSaida {

    private final Consulta consulta = new Consulta();

    public Boolean ConferirComprovanteDepagamento( Integer comprovanteSaida){
        ResultSet resultSet = consulta.executarConsulta("select * from pagamento " +
                                                 "where comprovante_pagamento = "+comprovanteSaida);
        try{
            if(resultSet.next()){
                ResultSet resultSetComprovante = consulta.executarConsulta("UPDATE vaga set sit_vaga = 0 where " +
                        "id_vaga  = " +
                        "(select id_vaga from uso where id_pagamento =  (select id_pagamento from pagamento " +
                        "where comprovante_pagamento = "+comprovanteSaida+"));");
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


        return null;
    }
}
