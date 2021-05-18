package br.com.parkineasy.repository.impl;

import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.UsoRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsoRepositoryImpl implements UsoRepository {

    private final Consulta consulta = new Consulta();

    @Override
    public LocalTime recuperarHorasDeUso(Integer codigoTicket) {
        ResultSet resultSet = consulta.executarConsulta(
                "SELECT TIMEDIFF(NOW(), data_hora_entrada) AS horas_de_uso" +
                        " FROM uso WHERE id_reserva = " + codigoTicket);
        DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm:ss");

        try {
            LocalTime horasDeUso = null;

            if (resultSet.next()) {
                horasDeUso = LocalTime.parse(resultSet.getString("horas_de_uso"), horaFormato);
            }

            return horasDeUso;
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());

            return null;
        }
    }
}