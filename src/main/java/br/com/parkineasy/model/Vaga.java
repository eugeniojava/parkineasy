package br.com.parkineasy.model;

import br.com.parkineasy.model.enums.TipoVaga;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Vaga {

    private String codigoVaga;
    private Long codigoTicket;
    private LocalDateTime dataHorarioReserva;
    private TipoVaga tipoVaga;

    //TODO buscarVaga()
    //TODO gerarTicket()
    //TODO painelVagas()
}
