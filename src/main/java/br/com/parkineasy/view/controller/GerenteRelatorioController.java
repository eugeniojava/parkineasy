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

    private static YearMonth data;
    public static void dateReceiver(YearMonth dat){
        data = dat;
    }
//    @FXML
//    private DatePicker dpDataGerarRelatorio;
//    @FXML
//    private Button btConfirmarGerarRelatorio;
//    @FXML
//    private Button btVoltarGerarRelatorio;
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
    private TableColumn<Relatorio, LocalTime> colTempoRelatorio;
    @FXML
    private TableColumn<Relatorio, BigDecimal> colValorRelatorio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ObservableList<Relatorio> oblist = FXCollections.observableArrayList(gerenteRepository.gerarRelatorio(data));


        colTicketRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("codigoTicket"));
        colVagaRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("codigoVaga"));
        colComprovanteRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("codigoComprovante"));
        colEntradaRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("entrada"));
        colSaidaRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("saida"));
        colTempoRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("totalHoras"));
        colValorRelatorio.setCellValueFactory(
                new PropertyValueFactory<>("valorPago"));

        tableRelatorio.setItems(oblist);

    }


//    public void pressButtonGerarRelatorio(ActionEvent event) throws MalformedURLException {
//        switch (((Control) event.getSource()).getId()) {
//            case "btConfirmarGerarRelatorio": {
//                if (dpDataGerarRelatorio.getEditor().getText().equals("")) {
//                    App.infoBox("A Data Alvo Não Pode Ser Nula!", "Geração de Relatório", null);
//                } else {
//                    data = dpDataGerarRelatorio.getValue();
//                    App.infoBox("Relatório Gerado Com Sucesso!", "Geração de Relatório", null);
//                    URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
//                            "\\view\\fxml\\EmitirRelatorio.fxml").toUri().toURL();
//                    App.nextScene("Emissão de Relatório", 600, 735, url, event);
//                }
//
//                break;
//            }
//            case "btVoltarEmissaoRelatorio": {
//                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
//                        "\\view\\fxml\\GerarRelatorio.fxml").toUri().toURL();
//                App.nextScene("Geração de Relatório", 520, 400, url, event);
//                break;
//            }
//
//            case "btVoltarGerarRelatorio": {
//                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
//                        "\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
//                App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
//                break;
//            }
//        }
//    }
}
