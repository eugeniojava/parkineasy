package br.com.parkineasy.service;

import java.math.BigDecimal;
import java.time.LocalTime;

public interface PagamentoService {

    BigDecimal calcularValorPagamento(Integer codigoTicket, LocalTime horasDeUso);
}
