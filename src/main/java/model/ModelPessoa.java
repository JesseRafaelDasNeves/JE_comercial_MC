package model;

import dao.DaoPessoa;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jessé
 */
@Entity
@SequenceGenerator(name = "sequencia_codigo", schema = "unico", sequenceName = "sequencia_pessoa", allocationSize = 1, initialValue = 1)
@Table(name = "tbpessoa", schema = "unico")
public class ModelPessoa implements Serializable, Cloneable, Comparable<ModelPessoa> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_codigo")
    @Column(name = "pescodigo")
    private int    codigo;
    
    @Column(name = "pesnome")
    private String nome;
    
    @Column(name = "pescpfcnpj")
    private String cpfCnpj;
    
    @Column(name = "pestipo")
    private int tipo;

    public ModelPessoa() {
        this.codigo = 0;
        this.nome = "";
        this.cpfCnpj = "";
        this.tipo = 0;
    }
    
    public ModelPessoa(int codigo, String nome, String cpfCnpj, int tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
    }
    
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
    
    public String getDescricaoTipoPessoa() {
        Lista oListaTipo = Lista.getByCodigo(DaoPessoa.getTipoPessoa(), this.tipo);
        
        if(oListaTipo != null) {
            return oListaTipo.getValor();
        }
        
        return "Indefinido";
    }
    
    public ModelPessoa getClone() {
        try {
            return (ModelPessoa)super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }

    @Override
    public int compareTo(ModelPessoa oPessoaDoArray) {
        if (this.codigo < oPessoaDoArray.codigo) {
            return -1;
        }
        if (this.codigo > oPessoaDoArray.codigo) {
            return 1;
        }
        return 0;
    }
}
