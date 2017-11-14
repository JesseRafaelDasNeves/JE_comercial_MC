package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jessé
 */
@Entity
@Table(name = "tbpessoa")
public class ModelPessoa implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "pescodigo")
    private int    codigo;
    
    @Column(name = "pesnome")
    private String nome;
    
    @Column(name = "pescpfcnpj")
    private String cpfCnpj;
    
    @Column(name = "pestipo")
    private int tipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
