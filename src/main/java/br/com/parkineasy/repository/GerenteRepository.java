package br.com.parkineasy.repository;

import br.com.parkineasy.model.Relatorio;

import java.time.LocalDate;
import java.util.List;

public interface GerenteRepository {

    Boolean ConsultaGerente(String userName, String senha);


    List<Relatorio>GeralRelatorio(LocalDate data);

   // String reImprimirTicket(String codigoVaga);

}
