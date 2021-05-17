package br.com.parkineasy.repository.impl;

import br.com.parkineasy.model.Gerente;
import br.com.parkineasy.model.Relatorio;
import br.com.parkineasy.repository.Consulta;
import br.com.parkineasy.repository.GerenteRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenteRepositoryImpl implements GerenteRepository {

    private final Consulta consulta = new Consulta();
    String name, passw;

    public static void main(String[] args) {
        GerenteRepositoryImpl gerenteRepository = new GerenteRepositoryImpl();
        String nome = "Bruno";
        String pass = "ABC123";
        gerenteRepository.ConsultaGerente(nome, pass);

    }

    @Override
    public List<Gerente> ConsultaGerente(String userName, String senha) {
        ResultSet resultSet = consulta.executaConsulta("select *from gerente where username_gerente ='" + userName +
                "'and password_gerente ='" + senha + "'");
        List<Gerente> gerente = new ArrayList<>();
        try {
            if (resultSet.next()) {
                name = resultSet.getString(3);
                passw = resultSet.getString(4);
                System.out.println(name + passw);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Relatorio>GeralRelatorio(LocalDateTime data)  {
        ResultSet resultSet = consulta.executaConsulta("select * from uso where date(data_hora_entrada) ='"+data+"'");
        List<Relatorio> relatorios = new ArrayList<>();

        try{
            while(resultSet.next()){
                Relatorio relatorio = new Relatorio();
                relatorio.setCodigoTicket(resultSet.getInt(1));
                relatorio.setCodigoVaga(resultSet.getString(2));
                relatorio.setCodigoComprovante(resultSet.getInt(3));
                relatorio.setEntrada(resultSet.getDate(4));
                relatorio.setSaida(resultSet.getDate(5));
                //relatorio.setTotalHoras(resultSet.getDate(6));
                relatorio.setValorPago(resultSet.getBigDecimal(7));

                relatorios.add(relatorio);
            }
            relatorios.forEach(System.out::println);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        GerenteRepositoryImpl gerenteRepository = new GerenteRepositoryImpl();
        String nome = "Bruno";
        String pass = "ABC123";
        LocalDateTime data = LocalDateTime.of(2021,05,16, 20,20,00);
        //System.out.println(data);
        //gerenteRepository.ConsultaGerente(nome,pass);
        gerenteRepository.GeralRelatorio(data);
    }

}

