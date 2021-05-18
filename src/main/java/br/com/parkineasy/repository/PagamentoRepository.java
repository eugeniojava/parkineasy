package br.com.parkineasy.repository;

import br.com.parkineasy.model.ComprovantePagamento;

import java.math.BigDecimal;

public interface PagamentoRepository {

    Boolean salvar(Integer codigoTicket, Integer metodoPagamento, BigDecimal valorTotal);

    ComprovantePagamento mostraComprovante (Integer codigoTicket);

}

