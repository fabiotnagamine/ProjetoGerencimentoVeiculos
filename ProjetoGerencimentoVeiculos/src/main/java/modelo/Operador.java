package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="operador")
@DiscriminatorValue("Operador")

@NamedQueries({
        @NamedQuery(name = "Operador.autenticar",
                query = "SELECT o FROM Operador o WHERE o.login = :login AND o.senha = :senha")
})
public class Operador extends Pessoa implements Serializable {

    @Column(length = 30)
    private String login;

    @Column(length = 30)
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Operador(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Operador(String nome, Endereco endereco) {
        super(nome, endereco);
    }

    public Operador() {
    }

    public String toString() {
        return login + " - " + senha;
    }
}