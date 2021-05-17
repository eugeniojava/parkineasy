package br.com.parkineasy.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class Relatorio {

    private Integer codigoTicket;
    private String codigoVaga;
    private Integer codigoComprovante;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Float totalHoras;
    private BigDecimal valorPago;

    public Relatorio() {
    }


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

    public LocalDateTime getEntrada() {
        return entrada;
    }

   public void setEntrada(LocalDateTime entrada) {
       this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }


    public void setEntrada(Date date) {
    }

    public void setSaida(Date date) {
    }
}
