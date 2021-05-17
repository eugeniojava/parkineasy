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


public class EmitirTicketController {

    public void pressButtonTipo(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btComumTipoVaga":
                App.infoBox("Vaga Comum Selecionada Com Sucesso!", "Tipo de Vaga", null);
                break;
            case "btIdosoTipoVaga":
                App.infoBox("Vaga de Idoso Selecionada Com Sucesso!", "Tipo de Vaga", null);

                break;
            case "btDeficienteTipoVaga":
                App.infoBox("Vaga de Deficiente Selecionada Com Sucesso!", "Tipo de Vaga", null);
                break;
        }
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\LocalVaga.fxml").toUri().toURL();
        App.nextScene("Seleção do Local da Vaga", 600, 600, url, event);
    }
    public void pressBack(ActionEvent event) throws MalformedURLException {
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TipoVaga.fxml").toUri().toURL();
        App.nextScene("Seleção do Tipo de Vaga", 407, 330, url, event);
    }
    public void selectRow(MouseEvent mouse) throws MalformedURLException {
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\EmitirTicket.fxml").toUri().toURL();
        Parent root;
        try {
            root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle("Emissão de Ticket");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
            ((Node)(mouse.getSource())).getScene().getWindow().hide();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void pressButtonPagamento(ActionEvent event) throws MalformedURLException {
        App.infoBox("Iniciando Processo de Pagamento!", "Processo de Pagamento", null);
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\InserirTicket.fxml").toUri().toURL();
        App.nextScene("Inserção de Ticket", 520, 400, url, event);
    }



}
