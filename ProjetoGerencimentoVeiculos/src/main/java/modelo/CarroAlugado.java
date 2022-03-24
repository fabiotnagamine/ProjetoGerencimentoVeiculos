package modelo;


import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import modelo.Motorista;
import modelo.Veiculo;

@Entity
@Table(name = "Alugado")
public class CarroAlugado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getdataEntrega() {
        return dataEntrega;
    }

    public void setdataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @JoinColumn(name="veiculo", referencedColumnName="id")
    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    private Veiculo veiculo;

    @JoinColumn(name="motorista", referencedColumnName="id")
    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    private Motorista motorista;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataRetirada;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataEntrega;

    @Override
    public String toString() {
        if(this.dataEntrega != null){
            return "Veiculo: " + this.getVeiculo() + " Devolvido por " + this.getMotorista() +
                    " No dia: " + this.getdataEntrega();
        }else if(dataRetirada != null){
            return "Motorista: " + this.getMotorista() + " Retirou o Veiculo: " + this.getVeiculo() +
                    " Na data de: " + this.getDataRetirada();
        }else{
            return this.getMotorista() + " " + this.getVeiculo();
        }

    }
}
