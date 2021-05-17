package br.com.parkineasy.repository;

import java.time.LocalDateTime;

public interface PagamentoRepository {

    Boolean efetuarPagamento(Integer codigoTicket, Integer pagamento);

    Float CalculaValor(LocalDateTime datadopagamento, Integer codigoTicket);
}
