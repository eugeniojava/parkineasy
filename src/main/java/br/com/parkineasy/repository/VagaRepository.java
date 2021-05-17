package br.com.parkineasy.repository;

import br.com.parkineasy.model.Vaga;

import java.util.List;

public interface VagaRepository {

    List<Vaga> listaTodas();

    List<Vaga> listaPorTipo(Integer tipo);

    //Integer Buscaticket(Integer ticket);

    //Integer BuscaComprovante(Integer comprovante);
}
