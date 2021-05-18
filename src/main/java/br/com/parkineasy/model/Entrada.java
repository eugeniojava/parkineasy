package br.com.parkineasy.model;

import java.time.LocalDateTime;

public class Entrada {

    private Integer codigoTicket;
    private LocalDateTime dataHoraEntrada;
    private String codigoVaga;

    public Integer getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(Integer codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(String codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "codigoTicket=" + codigoTicket +
                ", horaEntrada=" + dataHoraEntrada +
                ", codigoDaVaga='" + codigoVaga + '\'' +
                '}';
    }
}
