package br.com.parkineasy.view.controller;

import br.com.parkineasy.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.regex.Pattern;


public class PagamentoController {

    @FXML private TextField tfCodigoInserirTicket;


    public void validaInputPagamento(KeyEvent event) {
        String regex = "^[0-9]+$";
        String input = event.getCharacter();
        if (!Pattern.matches(regex, input)) {
            tfCodigoInserirTicket.setText("");
        }
    }

    public void pressBack(ActionEvent event) throws MalformedURLException {
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\EmitirTicket.fxml").toUri().toURL();
        App.nextScene("Emissão de Ticket", 600, 400, url, event);
    }

    public void pressButtonConfirm(ActionEvent event) throws MalformedURLException {
        if(tfCodigoInserirTicket.getText().equals("")){
            App.infoBox("O código do ticket não pode ser vazio!", "Inserção de Ticket", null);
        }else{
            App.infoBox("Ticket Inserido Com Sucesso!", "Inserção de Ticket", null);
            URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\MetodoPagamento.fxml").toUri().toURL();
            App.nextScene("Seleção do Método de Pagamento", 600, 400, url, event);
        }

    }

    public void pressButtonMetodo(ActionEvent event) throws MalformedURLException {
        switch (((Control) event.getSource()).getId()) {
            case "btCartaoMetodoPagamento":
                App.infoBox("Pagamento Via Cartão Selecionado!", "Seleção do Método de Pagamento", null);
                break;
            case "btDinheiroMetodoPagamento":
                App.infoBox("Pagamento Em Dinheiro Selecionado!", "Seleção do Método de Pagamento", null);
                break;
        }
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\PagamentoFinalizado.fxml").toUri().toURL();
        App.nextScene("Finalização do Pagamento - Emissão de Comprovante", 600, 400, url, event);
    }

    public void pressButtonFinalPag(ActionEvent event) throws MalformedURLException {
        App.infoBox("Saindo Do Estacionamento!", "Redirecionando Para a Saída", null);
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\InserirComprovante.fxml").toUri().toURL();
        App.nextScene("Saída do Estacionamento", 520, 400, url, event);
    }

    @FXML private TextField tfCodigoSaida;

    public void validaInputSaida(KeyEvent event) {
        String regex = "^[0-9]+$";
        String input = event.getCharacter();
        if (!Pattern.matches(regex, input)) {
            tfCodigoSaida.setText("");
        }
    }

    public void pressButtonConfirmSaida(ActionEvent event) throws MalformedURLException {
        if(tfCodigoSaida.getText().equals("")){
            App.infoBox("O código do comprovante não pode ser vazio!", "Inserção de Comprovante", null);
        }else{
            App.infoBox("Saída Confirmada - Agradecemos Pela Confiança!", "Inserção de Comprovante", null);
            URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\TipoVaga.fxml").toUri().toURL();
            App.nextScene("Seleção do Tipo de Vaga", 407, 330, url, event);
        }

    }

    public void pressBackSaida(ActionEvent event) throws MalformedURLException{
        URL url = Paths.get("C:\\Users\\MARCOS\\Desktop\\parkineasy\\src\\main\\java\\br\\com\\parkineasy\\view\\fxml\\PagamentoFinalizado.fxml").toUri().toURL();
        App.nextScene("Finalização do Pagamento - Emissão de Comprovante", 600, 400, url, event);
    }
}
