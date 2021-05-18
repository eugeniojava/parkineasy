package br.com.parkineasy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Relatorio {

    private Integer codigoTicket;
    private String codigoVaga;
    private Integer codigoComprovante;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraPagamento;
    private LocalTime totalHoras;
    private BigDecimal valorPago;

    public Integer getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(Integer codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public String getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(String codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public Integer getCodigoComprovante() {
        return codigoComprovante;
    }

    public void setCodigoComprovante(Integer codigoComprovante) {
        this.codigoComprovante = codigoComprovante;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public LocalTime getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(LocalTime totalHoras) {
        this.totalHoras = totalHoras;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "codigoTicket=" + codigoTicket +
                ", codigoVaga='" + codigoVaga + '\'' +
                ", codigoComprovante=" + codigoComprovante +
                ", dataHoraEntrada=" + dataHoraEntrada +
                ", dataHoraSaida=" + dataHoraSaida +
                ", dataHoraPagamento=" + dataHoraPagamento +
                ", totalHoras=" + totalHoras +
                ", valorPago=" + valorPago +
                '}';
    }
}
