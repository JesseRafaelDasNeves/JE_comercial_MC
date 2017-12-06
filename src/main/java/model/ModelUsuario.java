package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author jessé
 */
@Entity
@Table(name = "tbusuario", schema = "unico")
public class ModelUsuario implements Serializable {
    
    @Column(name = "usulogin")
    private String login;
    
    @Column(name = "ususenha")
    private String senha;
    
    @Id
    @OneToOne
    @JoinColumn(name = "pescodigo")
    private ModelPessoa Pessoa;

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

    public ModelPessoa getPessoa() {
        if(this.Pessoa == null) {
            this.Pessoa = new ModelPessoa();
        }
        return Pessoa;
    }

    public void setPessoa(ModelPessoa Pessoa) {
        this.Pessoa = Pessoa;
    }
}
