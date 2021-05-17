package br.com.parkineasy.repository;

import br.com.parkineasy.model.Gerente;
import br.com.parkineasy.model.Relatorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface GerenteRepository {

    List<Gerente> ConsultaGerente(String userName, String senha);

    List<Relatorio>GeralRelatorio(LocalDateTime data);

}
