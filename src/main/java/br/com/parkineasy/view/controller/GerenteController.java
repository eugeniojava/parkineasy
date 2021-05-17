package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.view.fxml.ModelTableConsultarVagas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class GerenteController implements Initializable{

    @FXML private TextField tfUsernameLoginGerente;
    @FXML private TextField tfPasswordLoginGerente;

    public void pressButtonCancelLogin(ActionEvent event) throws MalformedURLException {
        App.infoBox("Cancelando Login de Gerente!", "Login de Gerente", null);
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TelaInicial.fxml").toUri().toURL();
        App.nextScene("Seleção de Módulo", 520, 400, url, event);
    }

    public void pressButtonConfirmLogin(ActionEvent event) throws MalformedURLException {
        if(tfUsernameLoginGerente.getText().equals("") || tfPasswordLoginGerente.getText().equals("")){
            App.infoBox("Todos os campos devem ser preenchidos!", "Login de Gerente", null);
        }else{
            App.infoBox("Gerente Autenticado Com Sucesso!", "Login de Gerente", null);
            URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
            App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
        }

    }

    public void pressButtonMenuGerente(ActionEvent event) throws MalformedURLException{
        switch (((Control) event.getSource()).getId()) {
            case "btGerarRelatorioPainel": {
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\GerarRelatorio.fxml").toUri().toURL();
                App.nextScene("Geração de Relatório", 520, 400, url, event);
                break;
            }
            case "btConsultarVagasPainel": {
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\ConsultarVagas.fxml").toUri().toURL();
                App.nextScene("Painel de Vagas do Estacionamento", 600, 600, url, event);
                break;
            }
            case "btReimprimirTicketPainel": {
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\ReimprimirTicket.fxml").toUri().toURL();
                App.nextScene("Reimpressão de Ticket", 520, 400, url, event);
                break;
            }
            case "btSairPainel": {
                App.infoBox("Fazendo Logout...", "Painel de Controle do Estacionamento", null);
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\LoginGerente.fxml").toUri().toURL();
                App.nextScene("Login da Gerência", 520, 400, url, event);
                break;
            }
        }
    }

    @FXML private DatePicker dpDataGerarRelatorio;
    public void pressButtonGerarRelatorio(ActionEvent event) throws MalformedURLException{
        switch (((Control) event.getSource()).getId()) {
            case "btConfirmarGerarRelatorio": {
                if (dpDataGerarRelatorio.getEditor().getText().equals("")) {
                    App.infoBox("A Data Alvo Não Pode Ser Nula!", "Geração de Relatório", null);
                }else{
                    App.infoBox("Relatório Gerado Com Sucesso!", "Geração de Relatório", null);
                    URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\EmitirRelatorio.fxml").toUri().toURL();
                    App.nextScene("Emissão de Relatório", 600, 735, url, event);
                }

                break;
                }
            case "btVoltarEmissaoRelatorio": {
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\GerarRelatorio.fxml").toUri().toURL();
                App.nextScene("Geração de Relatório", 520, 400, url, event);
                break;
            }

            case "btVoltarGerarRelatorio": {
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
                App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
                break;
            }
        }
    }

    public void pressButtonConsultarVagas(ActionEvent event) throws MalformedURLException{
        if ("btVoltarPainelVagas".equals(((Control) event.getSource()).getId())) {
            URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
            App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
        }
    }

    @FXML private TextField tfCodigoReimprimirTicket;
    public void pressButtonReimprimirTicket(ActionEvent event) throws MalformedURLException{
        switch (((Control) event.getSource()).getId()) {
            case "btConfirmarReimprimirTicket": {
                if(tfCodigoReimprimirTicket.getText().equals("")){
                    App.infoBox("O código do ticket não pode ser vazio!", "Reimprimir Ticket", null);
                }else{
                    App.infoBox("Reimpressão de Ticket Realizada Com Sucesso!", "Reimprimir Ticket", null);
                    tfCodigoReimprimirTicket.clear();
                    tfCodigoReimprimirTicket.requestFocus();
                }

                break;
            }
            case "btVoltarReimprimirTicket": {
                URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\GerenteInicial.fxml").toUri().toURL();
                App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
                break;
            }
        }
    }


    @FXML private TableView<ModelTableConsultarVagas> tableConsultarVagas;
    @FXML private TableColumn<ModelTableConsultarVagas, String> colAConsultarVagas;
    @FXML private TableColumn<ModelTableConsultarVagas, String> colBConsultarVagas;
    @FXML private TableColumn<ModelTableConsultarVagas, String> colCConsultarVagas;

    ObservableList<ModelTableConsultarVagas> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources){

        ModelTableConsultarVagas m1 = new ModelTableConsultarVagas("A1","COMUM",0);
        ModelTableConsultarVagas m2 = new ModelTableConsultarVagas("A2","COMUM",0);
        ModelTableConsultarVagas m3 = new ModelTableConsultarVagas("A3","COMUM",0);
        ModelTableConsultarVagas m4 = new ModelTableConsultarVagas("A4","COMUM",0);
        ModelTableConsultarVagas m5 = new ModelTableConsultarVagas("A5","COMUM",0);
        ModelTableConsultarVagas m6 = new ModelTableConsultarVagas("A6","COMUM",0);
        ModelTableConsultarVagas m7 = new ModelTableConsultarVagas("A7","COMUM",0);
        ModelTableConsultarVagas m8 = new ModelTableConsultarVagas("A8","COMUM",0);
        ModelTableConsultarVagas m9 = new ModelTableConsultarVagas("A9","COMUM",0);
        ModelTableConsultarVagas m10 = new ModelTableConsultarVagas("A10","COMUM",0);
        oblist.addAll(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10);
        colAConsultarVagas.setCellValueFactory(new PropertyValueFactory<>("A"));
        colBConsultarVagas.setCellValueFactory(new PropertyValueFactory<>("B"));
        colCConsultarVagas.setCellValueFactory(new PropertyValueFactory<>("C"));

        tableConsultarVagas.setItems(oblist);
    }

}
