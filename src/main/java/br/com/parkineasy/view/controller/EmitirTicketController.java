package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.model.Entrada;
import br.com.parkineasy.repository.impl.ReservaRepositoryImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;


public class EmitirTicketController{

    ReservaRepositoryImpl reservaRepository = new ReservaRepositoryImpl();

    @FXML TextArea taEmitirTicket;


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
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\LocalVaga.fxml").toUri().toURL();
        App.nextScene("Seleção do Local da Vaga", 600, 600, url, event);
    }

    public void fillTicketField(MouseEvent mouse) throws MalformedURLException {
        Entrada entrada = reservaRepository.recuperarUltimaEntrada();
        System.out.println(entrada);
        taEmitirTicket.setText(entrada.toString());
    }

    public void pressButtonPagamento(ActionEvent event) throws MalformedURLException{
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\InserirTicket.fxml").toUri().toURL();
        App.nextScene("Inserção de Ticket", 520, 400, url, event);
    }
}
