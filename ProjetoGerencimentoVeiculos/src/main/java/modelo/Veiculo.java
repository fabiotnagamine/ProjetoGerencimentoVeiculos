package modelo;

import static javafx.application.Application.launch;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fabio
 */
@Entity
@Table(name = "veiculo")
public class Veiculo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String marca;

    @Column(length = 30)
    private String modelo;

   

    @Column(length = 8)
    private String placa;

    @Column(length = 30)
    private String cor;
    
    

    public Veiculo() {
        this.marca = "";
        this.modelo = "";
        this.placa = "";
        this.cor = "";
    }
    
    public static void main(String[] args){
        launch(args);
    }

    public Veiculo(String marca, String modelo, String placa, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
     @Override
    public String toString() {
        return "Marca: " + this.getMarca() +
                " Modelo: " + this.getModelo() +
                " Placa:" + this.getPlaca()+
                " Cor: " + this.getCor();
    }

}
