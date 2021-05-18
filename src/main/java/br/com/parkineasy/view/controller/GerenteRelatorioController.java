package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.model.Relatorio;
import br.com.parkineasy.model.Vaga;
import br.com.parkineasy.model.enums.TipoVaga;
import br.com.parkineasy.repository.impl.GerenteRepositoryImpl;
import br.com.parkineasy.repository.impl.VagaRepositoryImpl;
import br.com.parkineasy.view.model.VagaTableRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;

public class GerenteRelatorioController implements Initializable{

    GerenteRepositoryImpl gerenteRepository = new GerenteRepositoryImpl();

    private static YearMonth mesAno;
    @FXML
    private TableView<Relatorio> tableRelatorio;
    @FXML
    private TableColumn<Relatorio, Integer> colTicketRelatorio;
    @FXML
    private TableColumn<Relatorio, String> colVagaRelatorio;
    @FXML
    private TableColumn<Relatorio, Integer> colComprovanteRelatorio;
    @FXML
    private TableColumn<Relatorio, LocalDateTime> colEntradaRelatorio;
    @FXML
    private TableColumn<Relatorio, LocalDateTime> colSaidaRelatorio;
    @FXML
    private TableColumn<Relatorio, LocalDateTime> colPagamentoRelatorio;
    @FXML
    private TableColumn<Relatorio, LocalTime> colTempoRelatorio;
    @FXML
    private TableColumn<Relatorio, BigDecimal> colValorRelatorio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Relatorio> oblist = FXCollections.observableArrayList(gerenteRepository.gerarRelatorio(mesAno));


        colTicketRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("codigoTicket"));
        colVagaRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("codigoVaga"));
        colComprovanteRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("codigoComprovante"));
        colEntradaRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("dataHoraEntrada"));
        colSaidaRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("dataHoraSaida"));
        colPagamentoRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("dataHoraPagamento"));
        colTempoRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("totalHoras"));
        colValorRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("valorPago"));

        tableRelatorio.setItems(oblist);

    }

    public static void dateReceiver(YearMonth mesAn){
        mesAno = mesAn;
    }

    public void pressButtonVoltarEmissaoRelatorio(ActionEvent event) throws MalformedURLException{
        if(((Control) event.getSource()).getId().equals("btVoltarEmissaoRelatorio")){
            URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                    "\\view\\fxml\\GerarRelatorio.fxml").toUri().toURL();
            App.nextScene("Geração de Relatório", 520, 400, url, event);
        }
    }



}
