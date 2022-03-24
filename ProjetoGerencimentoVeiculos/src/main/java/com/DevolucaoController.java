package com;

import java.io.IOException;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.util.List;
import javafx.scene.control.DatePicker;
import util.Dao;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import modelo.CarroAlugado;


public class DevolucaoController {

    @FXML private ComboBox<CarroAlugado> carroAlugadoComboBox;
    private List<CarroAlugado> carroAlugadoList;
    private ObservableList<CarroAlugado> obsListCarro;

    @FXML private DatePicker datePickerRetirada;

    @FXML private DatePicker datePicker;


    public void initialize(){
        Dao<CarroAlugado> carroAlugadoDao = new Dao(CarroAlugado.class);
        carroAlugadoList = carroAlugadoDao.listarTodos();
        obsListCarro = FXCollections.observableArrayList(carroAlugadoList);
        carroAlugadoComboBox.getItems().addAll(obsListCarro);

        datePicker.setValue(LocalDate.now());

    }

    @FXML
    private void calculoData(){
        CarroAlugado constante = carroAlugadoComboBox.getValue();

        datePickerRetirada.setValue(constante.getDataRetirada());
    }
    @FXML
    private void devolverCarro(){
        CarroAlugado carroAlugado = carroAlugadoComboBox.getValue();
        Dao<CarroAlugado> carroAlugadoDao = new Dao<>(CarroAlugado.class);
        carroAlugado.setdataEntrega(datePicker.getValue());
        carroAlugadoDao.alterar(carroAlugado);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Devolução feita com sucesso");
        alerta.showAndWait();
    }
    @FXML
    private void cancelar() throws IOException {
        App.setRoot("principal");
    }


}
