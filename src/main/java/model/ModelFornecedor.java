package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jessé
 */
@Entity
@SequenceGenerator(name = "sequencia_codigo_fornecedor", schema = "unico", sequenceName = "sequencia_fornecedor", allocationSize = 1, initialValue = 1)
@Table(name = "tbfornecedor", schema = "unico")
public class ModelFornecedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_codigo_produto")
    @Column(name = "forcodigo")
    private int codigo;
    
    @Column(name = "forinscricaoestadual")
    private String inscricaoEstadual;
    
    
    @ManyToOne
    @JoinColumn(name = "pescodigo")
    private ModelPessoa Pessoa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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
