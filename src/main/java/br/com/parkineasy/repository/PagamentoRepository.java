package br.com.parkineasy.repository;

import java.math.BigDecimal;

public interface PagamentoRepository {

    Boolean salvar(Integer codigoTicket, Integer metodoPagamento, BigDecimal valorTotal);

}

