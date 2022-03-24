package com;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import modelo.CarroAlugado;
import util.Dao;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListarVeiculos implements Initializable {
    ObservableList lista = FXCollections.observableArrayList();
    Dao<CarroAlugado> dao = new Dao(CarroAlugado.class);
    @FXML private ListView<CarroAlugado> carroAlugadoLisView;
    @FXML private List<CarroAlugado> carroAlugadolist;
    @FXML
    private void ListarVeiculos() {
        carroAlugadoLisView.getItems().clear();
        lista.addAll(dao.listarTodos());
        carroAlugadoLisView.setItems(lista);
    }


    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            carroAlugadoLisView.setItems(lista);
    }

    @FXML
    private void menu() throws IOException {
        App.setRoot("principal");
    }


}
