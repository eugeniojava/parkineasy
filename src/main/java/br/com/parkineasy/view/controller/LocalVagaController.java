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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static br.com.parkineasy.App.PARKINEASY_FOLDER;

public class LocalVagaController implements Initializable{
    @FXML
    private TableView<ModelTableConsultarVagas> tableLocalVaga;
    @FXML
    private TableColumn<ModelTableConsultarVagas, String> colCodigoLocalVaga;
    @FXML
    private TableColumn<ModelTableConsultarVagas, String> colSituacaoLocalVaga;
    @FXML
    private TableColumn<ModelTableConsultarVagas, String> colTipoLocalVaga;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCodigoLocalVaga.setCellValueFactory(
                new PropertyValueFactory<>("id_vaga"));
        colSituacaoLocalVaga.setCellValueFactory(
                new PropertyValueFactory<>("sit_vaga"));
        colTipoLocalVaga.setCellValueFactory(
                new PropertyValueFactory<>("tip_vaga"));

        tableLocalVaga.setItems(listaDeVagas());
    }


    private ObservableList<ModelTableConsultarVagas> listaDeVagas() {
        return FXCollections.observableArrayList(
                new ModelTableConsultarVagas("A01", 0, "DEFICIENTE"),
                new ModelTableConsultarVagas("B01", 0, "DEFICIENTE"),
                new ModelTableConsultarVagas("C01", 0, "DEFICIENTE")

        );
    }
    public void pressBack(ActionEvent event) throws MalformedURLException {
        URL url =
                Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TipoVaga.fxml").toUri().toURL();
        App.nextScene("Seleção do Tipo de Vaga", 407, 330, url, event);
    }
    public void selectRow(MouseEvent mouse) throws MalformedURLException {
        URL url = Paths.get(PARKINEASY_FOLDER + "\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\EmitirTicket" +
                ".fxml").toUri().toURL();
        Parent root;
        try {
            root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle("Emissão de Ticket");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
            ((Node) (mouse.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
