/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com;

import java.io.IOException;

import java.time.LocalDate;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.scene.control.DatePicker;
import modelo.CarroAlugado;
import modelo.Motorista;
import modelo.Veiculo;
import util.Dao;

public class RetiradaVeiculosController{

   
    Dao<Veiculo> daoVeiculo = new Dao(Veiculo.class);
    Dao<Motorista> daoMotorista = new Dao(Motorista.class);

    @FXML private ComboBox<Veiculo> comboVeiculo;
    private List<Veiculo> veiculos;
    private ObservableList<Veiculo> listaVeiculos;

    @FXML private ComboBox<Motorista> comboMotorista;
    private List<Motorista> motoristas;
    private ObservableList<Motorista> listaMotorista;

    @FXML private DatePicker datePicker;


 //id marca modelo placa e cor



    public void initialize() {

        datePicker.setValue(LocalDate.now());

        motoristas =daoMotorista.listarTodos();
        listaMotorista = FXCollections.observableArrayList(motoristas);
        comboMotorista.getItems().addAll(listaMotorista);
        comboMotorista.setValue(listaMotorista.get(0));

        veiculos = daoVeiculo.listarTodos();
        listaVeiculos = FXCollections.observableArrayList(veiculos);
        comboVeiculo.getItems().addAll(listaVeiculos);
        comboVeiculo.setValue(listaVeiculos.get(0));


    }
    @FXML
    private void RetirarVeiculo() throws IOException{
        CarroAlugado carroAlugado = new CarroAlugado();
        carroAlugado.setVeiculo(comboVeiculo.getValue());
        carroAlugado.setMotorista(comboMotorista.getValue());
        carroAlugado.setDataRetirada(datePicker.getValue());
        Dao<CarroAlugado> dao = new Dao(CarroAlugado.class);
        dao.inserir(carroAlugado);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Veiculo retirado com sucesso");
        alerta.showAndWait();
    }
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("principal");
    }


}
