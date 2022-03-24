package com;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrincipalController {

    

    @FXML
    private void cadastrarVeiculos() throws IOException {
        App.setRoot("veiculo");
    }
    @FXML
    private void cadastrarMotorista() throws IOException{
        App.setRoot("motorista");
    }
    
    @FXML 
    private void RetirarVeiculos() throws IOException{
        App.setRoot("retirarVeiculos");
    }

    @FXML
    private void ListarVeiculos() throws IOException{
        App.setRoot("listarVeiculos");
    }

    @FXML
    private void devolverCarro() throws IOException {
        App.setRoot("devolucaoCarro");
    }

    @FXML
    private void CadastrarOperador() throws IOException{
        App.setRoot("cadastrarOperador");
    }
}
