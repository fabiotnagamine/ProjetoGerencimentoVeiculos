package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Endereco;
import modelo.Motorista;
import util.Dao;
import modelo.Buscador;

/**
 * FXML Controller class
 *
 * @author fabio
 */
public class MotoristaController {

    @FXML
    private TextField fieldSecao;

    @FXML
    private TextField fieldNome;

    @FXML
    private TextField fieldCNH;

    @FXML
    private TextField fieldCEP;

    @FXML
    private TextField fieldCidade;

    @FXML
    private TextField fieldLogradouro;

    @FXML
    private TextField fieldEstado;

    private final Buscador buscador;
    private Endereco endereco;

    public MotoristaController() {
        buscador = new Buscador();
    }

    @FXML
    private void BuscarEndereco() {

        String cep = fieldCEP.getText();
        try {
            endereco = buscador.buscar(cep);
            fieldCidade.setText(endereco.getLocalidade());
            fieldLogradouro.setText(endereco.getLogradouro());
            fieldEstado.setText(endereco.getUf());
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    @FXML
    private void InserirMotorista() {

        String secao = fieldSecao.getText(),
                nome = fieldNome.getText(),
                cnh = fieldCNH.getText();
        endereco.setCep(fieldCEP.getText());
        endereco.setLocalidade(fieldCidade.getText());
        endereco.setLogradouro(fieldLogradouro.getText());
        endereco.setUf(fieldEstado.getText());
        
        
        Motorista motorista = new Motorista(cnh, secao, endereco, nome);
        Dao<Motorista> daoM = new Dao(Motorista.class);
        daoM.inserir(motorista);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Motorista e Endereco cadastrado com sucesso");
        alerta.showAndWait();

        fieldNome.setText("");
        fieldSecao.setText("");
        fieldCNH.setText("");
        fieldCEP.setText("");
        fieldCidade.setText("");
        fieldLogradouro.setText("");
        fieldEstado.setText("");
        fieldNome.requestFocus();
    }

    @FXML
    private void Cancelar() throws IOException {

        App.setRoot("principal");

    }
}
