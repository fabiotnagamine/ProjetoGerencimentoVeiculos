package com;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Buscador;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Endereco;
import modelo.Motorista;
import modelo.Operador;
import util.Dao;

public class CadastrarOperadorController {

    @FXML
    private TextField fieldCEP;

    @FXML
    private TextField fieldLogradouro;

    @FXML
    private TextField fieldCidade;

    @FXML
    private TextField fieldUF;

    @FXML
    private TextField fieldBairro;

    @FXML
    private TextField fieldNome;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldSenha;

    @FXML
    private TextField fieldComplemento;

    private Buscador buscador;
    private Endereco endereco;

    public CadastrarOperadorController(){
        buscador = new Buscador();
    }

    @FXML
    private void buscar() {
        String cep = fieldCEP.getText();
        try {
            endereco = buscador.buscar(cep);
            fieldCidade.setText(endereco.getLocalidade());
            fieldUF.setText(endereco.getUf());
            fieldLogradouro.setText(endereco.getLogradouro());

        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait();
        }
        catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    @FXML
    private void cadastrarOperador() {
        String nome = fieldNome.getText();
        String login = fieldLogin.getText();
        String senha = fieldSenha.getText();


        Endereco endereco = new Endereco();
        endereco.setCep(fieldCEP.getText());
        endereco.setLocalidade(fieldCidade.getText());
        endereco.setLogradouro(fieldLogradouro.getText());
        endereco.setUf(fieldUF.getText());

        Operador operador = new Operador(fieldNome.getText(), endereco);
        operador.setLogin(fieldLogin.getText());
        operador.setSenha(fieldSenha.getText());
        Dao<Operador> dao = new Dao(Operador.class);
        dao.inserir(operador);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("Cadastrado confirmado");
        alerta.showAndWait();

        fieldNome.setText("");
        fieldLogin.setText("");
        fieldSenha.setText("");
        fieldCEP.setText("");
        fieldUF.setText("");
        fieldCidade.setText("");
        fieldLogradouro.setText("");
    }

    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }

}
