package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Veiculo;
import util.Dao;

public class VeiculoController {

    

    @FXML
    private TextField insereMarca;

    @FXML
    private TextField insereModelo;

    @FXML
    private TextField inserePlaca;

    @FXML
    private TextField insereCor;

    @FXML
    private Button insere;

    /**
     *e
     */
    @FXML
    public void insereMotorista() {
//        Veiculo veiculo = new Veiculo();
//        veiculo.setMarca(insereMarca.getText());
//        veiculo.setModelo(insereModelo.getText());
//        veiculo.setPlaca(inserePlaca.getText());
//        veiculo.setCor(insereCor.getText());

        String marca = insereMarca.getText();
        String modelo = insereModelo.getText();
        String Placa = inserePlaca.getText();
        String cor = insereCor.getText();
        Veiculo v = new Veiculo(marca, modelo, Placa, cor);
        Dao <Veiculo> dao = new Dao(Veiculo.class);
        dao.inserir(v);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Veiculo cadastrado com sucesso");
        alerta.showAndWait();
        insereMarca.setText("");
        insereModelo.setText("");
        inserePlaca.setText("");
        insereCor.setText("");
        insereMarca.requestFocus();
    }
     public void cancelar() throws IOException {
        App.setRoot("principal");
    }
}
