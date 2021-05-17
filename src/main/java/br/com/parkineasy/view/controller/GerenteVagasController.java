package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import br.com.parkineasy.view.fxml.ModelTableConsultarVagas;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;

public class GerenteVagasController implements Initializable{
    @FXML
    private TableView<ModelTableConsultarVagas> tableConsultarVagas;
    @FXML
    private TableColumn<ModelTableConsultarVagas, String> colAConsultarVagas;
    @FXML
    private TableColumn<ModelTableConsultarVagas, String> colBConsultarVagas;
    @FXML
    private TableColumn<ModelTableConsultarVagas, String> colCConsultarVagas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colAConsultarVagas.setCellValueFactory(
                new PropertyValueFactory<>("id_vaga"));
        colBConsultarVagas.setCellValueFactory(
                new PropertyValueFactory<>("sit_vaga"));
        colCConsultarVagas.setCellValueFactory(
                new PropertyValueFactory<>("tip_vaga"));

        tableConsultarVagas.setItems(listaDeVagas());
    }


    private ObservableList<ModelTableConsultarVagas> listaDeVagas() {
        return FXCollections.observableArrayList(
                new ModelTableConsultarVagas("A01", 0, "DEFICIENTE"),
                new ModelTableConsultarVagas("A02", 0, "IDOSO"),
                new ModelTableConsultarVagas("A03", 1, "COMUM"),
                new ModelTableConsultarVagas("A04", 1, "COMUM"),
                new ModelTableConsultarVagas("A05", 0, "COMUM"),
                new ModelTableConsultarVagas("A06", 0, "COMUM"),
                new ModelTableConsultarVagas("A07", 0, "COMUM"),
                new ModelTableConsultarVagas("A08", 1, "COMUM"),
                new ModelTableConsultarVagas("A09", 1, "COMUM"),
                new ModelTableConsultarVagas("A10", 0, "COMUM"),
                new ModelTableConsultarVagas("B01", 0, "DEFICIENTE"),
                new ModelTableConsultarVagas("B02", 0, "IDOSO"),
                new ModelTableConsultarVagas("B03", 1, "COMUM"),
                new ModelTableConsultarVagas("B04", 1, "COMUM"),
                new ModelTableConsultarVagas("B05", 0, "COMUM"),
                new ModelTableConsultarVagas("B06", 0, "COMUM"),
                new ModelTableConsultarVagas("B07", 0, "COMUM"),
                new ModelTableConsultarVagas("B08", 1, "COMUM"),
                new ModelTableConsultarVagas("B09", 1, "COMUM"),
                new ModelTableConsultarVagas("B10", 0, "COMUM"),
                new ModelTableConsultarVagas("C01", 0, "DEFICIENTE"),
                new ModelTableConsultarVagas("C02", 0, "IDOSO"),
                new ModelTableConsultarVagas("C03", 1, "COMUM"),
                new ModelTableConsultarVagas("C04", 1, "COMUM"),
                new ModelTableConsultarVagas("C05", 0, "COMUM"),
                new ModelTableConsultarVagas("C06", 0, "COMUM"),
                new ModelTableConsultarVagas("C07", 0, "COMUM"),
                new ModelTableConsultarVagas("C08", 1, "COMUM"),
                new ModelTableConsultarVagas("C09", 1, "COMUM"),
                new ModelTableConsultarVagas("C10", 0, "COMUM")

        );
    }
    public void pressButtonConsultarVagas(ActionEvent event) throws MalformedURLException {
        if ("btVoltarPainelVagas".equals(((Control) event.getSource()).getId())) {
            URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view" +
                    "\\fxml\\GerenteInicial.fxml").toUri().toURL();
            App.nextScene("Painel de Controle do Estacionamento", 600, 400, url, event);
        }
    }
}
