package modelo;

import javax.persistence.*;

@Entity
@Table(name = "motorista")
@DiscriminatorValue("Motorista")
public class Motorista extends Pessoa  {
    
    @Column(length = 30)
    private String cnh;

    @Column(length = 30)
    private String secao;
    
    @Embedded
    private Endereco endereco;



    public Endereco getEndereco() {
        return endereco;
    }

    public Motorista(){
        
    }

    public Motorista(String cnh, String secao, Endereco endereco, String nome) {
        super(nome, endereco);
        this.cnh = cnh;
        this.secao = secao;
    }
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String toString(){
        return this.getNome() ;
    }
   
}
