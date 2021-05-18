package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.model.Gerente;
import br.com.parkineasy.repository.impl.GerenteRepositoryImpl;
import br.com.parkineasy.view.fxml.ModelTableConsultarVagas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;

public class GerenteController{

//    GerenteRepositoryImpl gerenteRepository = new GerenteRepositoryImpl();

    @FXML
    private TextField tfUsernameLoginGerente;
    @FXML
    private TextField tfPasswordLoginGerente;
    @FXML
    private DatePicker dpDataGerarRelatorio;
    @FXML
    private TextField tfCodigoReimprimirTicket;

    public void pressButtonCancelLogin(ActionEvent event) throws MalformedURLException {
        App.infoBox("Cancelando Login de Gerente!", "Login de Gerente", null);
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml" +
                "\\TelaInicial.fxml").toUri().toURL();
        App.nextScene("Seleção de Módulo", 520, 400, url, event);
    }

    public void pressButtonConfirmLogin(ActionEvent event) throws MalformedURLException {
        if (tfUsernameLoginGerente.getText().equals("") || tfPasswordLoginGerente.getText().equals("")) {
            App.infoBox("Todos os campos devem ser preenchidos!", "Login de Gerente", null);
        } else {
//            gerenteRepository.ConsultaGerente(tfUsernameLoginGerente.getText(), tfPasswordLoginGerente.getText());
            App.infoBox("Gerente Autenticado Com Sucesso!", "Login de Gerente", null);
            URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view" +
                    "\\fxml\\GerenteInicial.fxml").toUri().toURL();
            App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
        }

    }

    public void pressButtonMenuGerente(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btGerarRelatorioPainel": {
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\GerarRelatorio.fxml").toUri().toURL();
                App.nextScene("Geração de Relatório", 520, 400, url, event);
                break;
            }
            case "btConsultarVagasPainel": {
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\ConsultarVagas.fxml").toUri().toURL();
                App.nextScene("Painel de Vagas do Estacionamento", 600, 600, url, event);
                break;
            }
            case "btReimprimirTicketPainel": {
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\ReimprimirTicket.fxml").toUri().toURL();
                App.nextScene("Reimpressão de Ticket", 520, 400, url, event);
                break;
            }
            case "btSairPainel": {
                App.infoBox("Fazendo Logout...", "Painel de Controle do Estacionamento", null);
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\LoginGerente.fxml").toUri().toURL();
                App.nextScene("Login da Gerência", 520, 400, url, event);
                break;
            }
        }
    }

    public void pressButtonGerarRelatorio(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btConfirmarGerarRelatorio": {
                if (dpDataGerarRelatorio.getEditor().getText().equals("")) {
                    App.infoBox("A Data Alvo Não Pode Ser Nula!", "Geração de Relatório", null);
                } else {
                    System.out.println(dpDataGerarRelatorio.getValue());
                    GerenteRelatorioController.dateReceiver(dpDataGerarRelatorio.getValue());
                    App.infoBox("Relatório Gerado Com Sucesso!", "Geração de Relatório", null);
                    URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                            "\\view\\fxml\\EmitirRelatorio.fxml").toUri().toURL();
                    App.nextScene("Emissão de Relatório", 600, 735, url, event);
                }

                break;
            }
            case "btVoltarEmissaoRelatorio": {
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\GerarRelatorio.fxml").toUri().toURL();
                App.nextScene("Geração de Relatório", 520, 400, url, event);
                break;
            }

            case "btVoltarGerarRelatorio": {
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
                App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
                break;
            }
        }
    }

    public void pressButtonConsultarVagas(ActionEvent event) throws MalformedURLException {
        if ("btVoltarPainelVagas".equals(((Control) event.getSource()).getId())) {
            URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view" +
                    "\\fxml\\GerenteInicial.fxml").toUri().toURL();
            App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
        }
    }

    public void pressButtonReimprimirTicket(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btConfirmarReimprimirTicket": {
                if (tfCodigoReimprimirTicket.getText().equals("")) {
                    App.infoBox("O código do ticket não pode ser vazio!", "Reimprimir Ticket", null);
                } else {
                    App.infoBox("Reimpressão de Ticket Realizada Com Sucesso!", "Reimprimir Ticket", null);
                    tfCodigoReimprimirTicket.clear();
                    tfCodigoReimprimirTicket.requestFocus();
                }

                break;
            }
            case "btVoltarReimprimirTicket": {
                URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                        "\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
                App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
                break;
            }
        }
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        colAConsultarVagas.setCellValueFactory(
//                new PropertyValueFactory<>("id_vaga"));
//        colBConsultarVagas.setCellValueFactory(
//                new PropertyValueFactory<>("tip_vaga"));
//        colCConsultarVagas.setCellValueFactory(
//                new PropertyValueFactory<>("sit_vaga"));
//
//        tableConsultarVagas.setItems(listaDeVagas());
//
//    }
//    private ObservableList<ModelTableConsultarVagas> listaDeVagas() {
//        return FXCollections.observableArrayList(
//                new ModelTableConsultarVagas("A1", "COMUM", "1"),
//                new ModelTableConsultarVagas("A2", "COMUM", "1"),
//                new ModelTableConsultarVagas("B5", "COMUM", "0"),
//                new ModelTableConsultarVagas("B9", "IDOSO", "0"),
//                new ModelTableConsultarVagas("C3", "DEFICIENTE", "0"),
//                new ModelTableConsultarVagas("C5", "DEFICIENTE", "1")
//        );
//    }




}
