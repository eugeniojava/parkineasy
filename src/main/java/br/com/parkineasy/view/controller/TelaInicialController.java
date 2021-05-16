package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import javafx.event.ActionEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class TelaInicialController {

    public void pressButtonCli(ActionEvent event) throws MalformedURLException {
        App.infoBox("Módulo de Cliente Selecionado Com Sucesso!", "Seleção de Módulo", null);
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TipoVaga.fxml").toUri().toURL();
        App.nextScene("Seleção do Tipo de Vaga", 407, 330, url, event);
    }
    public void pressButtonGer(ActionEvent event) throws MalformedURLException {
        App.infoBox("Módulo de Gerente Selecionado Com Sucesso!", "Seleção de Módulo", null);
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\LoginGerente.fxml").toUri().toURL();
        App.nextScene("Login da Gerência", 520, 400, url, event);
    }

}
