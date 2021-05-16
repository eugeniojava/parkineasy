package br.com.parkineasy.repository;

public interface VagaRepository {

    List<Vaga> listaTodas();

    Lista<Vaga> listaPorTipo(String tipo);
}
