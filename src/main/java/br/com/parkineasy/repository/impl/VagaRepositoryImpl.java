//package br.com.parkineasy.repository.impl;
//
//import br.com.parkineasy.repository.DatabaseConnection;
//import br.com.parkineasy.repository.VagaRepository;
//
//public class VagaRepositoryImpl implements VagaRepository {
//
//    private final DatabaseConnection databaseConnection = new DatabaseConnection();
//
//    private final VagaRepository vagaRepository;
//
//    public VagaRepositoryImpl(VagaRepository vagaRepository) {
//        this.vagaRepository = vagaRepository;
//    }
//
//    public void test() {
//        Produto produto = vagaRepository.findById(id);
//    }
//
//    @Override
//    public Vaga findVagaById(Long id) {
//        String query = "SELECT * FROM Vaga v WHERE v.id = :id";
//
//        Vaga vaga = databaseConnection.realizaConsulta(query);
//
//        return null;
//    }
//}
