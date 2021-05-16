package br.com.parkineasy.repository;

import br.com.parkineasy.model.Gerente;

import java.util.List;

public interface GerenteRepository {

    List<Gerente> ConsultaGerente(String userName, String senha);
}
