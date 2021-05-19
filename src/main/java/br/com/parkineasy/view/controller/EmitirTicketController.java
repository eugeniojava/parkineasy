package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.model.Entrada;
import br.com.parkineasy.repository.impl.ReservaRepositoryImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;


public class EmitirTicketController {

    ReservaRepositoryImpl reservaRepository = new ReservaRepositoryImpl();

    @FXML
    TextArea taEmitirTicket;

    public void pressButtonMenuCliente(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btTicketMenuCliente":
                App.infoBox("Opção de Emissão de Ticket Selecionada!", "Menu do Cliente", null);
                URL url =
                Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TipoVaga.fxml").toUri().toURL();
                App.nextScene("Seleção do Tipo de Vaga", 407, 330, url, event);
                break;
            case "btPagamentoMenuCliente":
                App.infoBox("Opção de Efetuar Pagamento Selecionada", "Menu do Cliente", null);
                url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\InserirTicket" +
                        ".fxml").toUri().toURL();
                App.nextScene("Inserção de Ticket", 520, 400, url, event);
                break;
            case "btVoltarMenuCliente":
                url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TelaInicial" +
                        ".fxml").toUri().toURL();
                App.nextScene("Seleção de Módulo", 520, 400, url, event);
                break;
        }

    }


    public void pressButtonTipo(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btComumTipoVaga":
                LocalVagaController.typeReceiver(1);
                App.infoBox("Vaga Comum Selecionada Com Sucesso!", "Tipo de Vaga", null);
                break;
            case "btIdosoTipoVaga":
                LocalVagaController.typeReceiver(2);
                App.infoBox("Vaga de Idoso Selecionada Com Sucesso!", "Tipo de Vaga", null);

                break;
            case "btDeficienteTipoVaga":
                LocalVagaController.typeReceiver(3);
                App.infoBox("Vaga de Deficiente Selecionada Com Sucesso!", "Tipo de Vaga", null);
                break;
        }
        URL url =
                Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\LocalVaga.fxml").toUri().toURL();
        App.nextScene("Seleção do Local da Vaga", 600, 600, url, event);
    }

    public void fillTicketField(){
        Entrada entrada = reservaRepository.recuperarUltimaEntrada();
        taEmitirTicket.setText(entrada.toString());
    }

    public void pressButtonConfirmarTicket(ActionEvent event) throws MalformedURLException {
        App.infoBox("Ticket Confirmado! Retornando Para o Menu do Cliente.", "Tipo de Vaga", null);
        URL url =
                Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\MenuCliente.fxml").toUri().toURL();
        App.nextScene("Menu do Cliente", 407, 375, url, event);
    }
}
