package br.com.parkineasy.repository;

import br.com.parkineasy.model.Vaga;

import java.util.List;

public interface VagaRepository {

    List<Vaga> listaTodas();

    List<Vaga> listaPorTipo(String tipo);
}
