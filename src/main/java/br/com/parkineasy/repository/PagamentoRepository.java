package br.com.parkineasy.repository;

public interface PagamentoRepository {

    Boolean salvar(Integer codigoTicket, Integer pagamento);
}
