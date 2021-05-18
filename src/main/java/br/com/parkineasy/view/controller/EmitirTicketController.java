package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;


public class EmitirTicketController {

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

    public void pressButtonPagamento(ActionEvent event) throws MalformedURLException{
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\InserirTicket.fxml").toUri().toURL();
        App.nextScene("Inserção de Ticket", 520, 400, url, event);
    }
}
