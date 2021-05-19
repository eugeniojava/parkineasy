package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.model.Entrada;
import br.com.parkineasy.model.Relatorio;
import br.com.parkineasy.repository.impl.GerenteRepositoryImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.util.List;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;

public class GerenteController {

    GerenteRepositoryImpl gerenteRepository = new GerenteRepositoryImpl();

    private static String tfReimprimirTicket;

    @FXML
    private TextField tfUsernameLoginGerente;
    @FXML
    private TextField tfPasswordLoginGerente;
//    @FXML
//    private DatePicker dpDataGerarRelatorio;
    @FXML
    private TextField tfCodigoReimprimirTicket;
    @FXML
    private TextArea taReimprimirTicket;
    @FXML
    private TextField tfMesAnoRelatorio;

    public void pressButtonCancelLogin(ActionEvent event) throws MalformedURLException {
        App.infoBox("Cancelando Login de Gerente!", "Login de Gerente", null);
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml" +
                "\\TelaInicial.fxml").toUri().toURL();
        App.nextScene("Seleção de Módulo", 520, 400, url, event);
    }

    public void pressButtonConfirmLogin(ActionEvent event) throws MalformedURLException {
        if (tfUsernameLoginGerente.getText().equals("") || tfPasswordLoginGerente.getText().equals("")) {
            App.infoBox("Todos os campos devem ser preenchidos!", "Login de Gerente", null);

        } else if (gerenteRepository.validarGerente(tfUsernameLoginGerente.getText(),
                tfPasswordLoginGerente.getText())) {
            App.infoBox("Gerente Autenticado Com Sucesso!", "Login de Gerente", null);
            URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view" +
                    "\\fxml\\GerenteInicial.fxml").toUri().toURL();
            App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
        } else {
            App.infoBox("O Usuário ou Senha Inseridos Estão Incorretos!", "Login de Gerente", null);
            tfUsernameLoginGerente.clear();
            tfPasswordLoginGerente.clear();
            tfUsernameLoginGerente.requestFocus();
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
                if (tfMesAnoRelatorio.getText() == null) {
                    App.infoBox("A Data Alvo Não Pode Ser Nula!", "Geração de Relatório", null);
                } else{
                    GerenteRelatorioController.dateReceiver(YearMonth.parse(tfMesAnoRelatorio.getText()));
                    App.infoBox("Relatório Gerado Com Sucesso!", "Geração de Relatório", null);
                    URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                            "\\view\\fxml\\EmitirRelatorio.fxml").toUri().toURL();
                    App.nextScene("Emissão de Relatório", 600, 735, url, event);
                }

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

    public void pressButtonReimprimirTicket(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btConfirmarReimprimirTicket": {
                if (tfCodigoReimprimirTicket.getText().equals("")) {
                    App.infoBox("O Código da Vaga Não Pode Ser Vazio!", "Reimprimir Ticket", null);
                } else if(gerenteRepository.recuperarPorCodigoVaga(tfCodigoReimprimirTicket.getText()) != null){
                    tfReimprimirTicket = tfCodigoReimprimirTicket.getText();
                    App.infoBox("Reimpressão de Ticket Realizada Com Sucesso!", "Reimprimir Ticket", null);
                    URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                            "\\view\\fxml\\TicketReimpresso.fxml").toUri().toURL();
                    App.nextScene("Reimpressão de Ticket", 600, 400, url, event);
                }else{
                    App.infoBox("O Código da Vaga Inserido É Inválido!", "Reimprimir Ticket", null);
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

    public void fillTicketReimpresso(MouseEvent mouse) throws MalformedURLException {
        Entrada entrada = gerenteRepository.recuperarPorCodigoVaga(tfReimprimirTicket);
        taReimprimirTicket.setText(entrada.toString());
    }

    public void pressButtonConfirmarReimpressao(ActionEvent event) throws MalformedURLException{
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy" +
                "\\view\\fxml\\ReimprimirTicket.fxml").toUri().toURL();
        App.nextScene("Reimpressão de Ticket", 520, 400, url, event);
    }



}
