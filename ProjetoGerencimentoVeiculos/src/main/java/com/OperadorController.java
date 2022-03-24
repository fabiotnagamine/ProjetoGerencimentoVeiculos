/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author fabio
 */
public class OperadorController  {

    @FXML
    private TextField fieldLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private void login() throws IOException {
//        DaoOperador daoOperador = new DaoOperador();
//        String login  = fieldLogin.getText();
//        String password = fieldPassword.getText();
//        Operador op = new Operador(login, password);
//
//        boolean autenticar = daoOperador.autenticar(op);
//
//        if(autenticar) {
//            System.out.println("PASSOU AQ");
        App.setRoot("principal");
//        } else {
//            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//            alerta.setHeaderText("Erro ao efetuar o login ");
//            alerta.setContentText("Usuário ou senha incorretos");
//            alerta.showAndWait();
//        }
    }
    
}
