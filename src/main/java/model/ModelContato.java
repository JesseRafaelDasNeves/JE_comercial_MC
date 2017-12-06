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
@Table(name = "tbcontato", schema = "unico")
public class ModelContato implements Serializable {
    
    @Column(name = "connrotelefone")
    private String numeroTelefone;
    
    @Column(name = "conemail")
    private String email;

    @Id
    @OneToOne
    @JoinColumn(name = "pescodigo")
    private ModelPessoa Pessoa;
    
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
