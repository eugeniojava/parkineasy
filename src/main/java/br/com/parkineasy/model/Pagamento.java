package br.com.parkineasy.model;

import br.com.parkineasy.model.enums.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

    private BigDecimal valorTotal;
    private LocalDateTime dataHorarioPagamento;
    private MetodoPagamento metodoPagamento;

    //TODO lerTicket()
    //TODO pagarTiket()
    //TODO finalizarPagamento()
}
