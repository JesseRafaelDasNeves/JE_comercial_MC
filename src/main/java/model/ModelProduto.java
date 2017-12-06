package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jessé
 */
@Entity
@SequenceGenerator(name = "sequencia_codigo_produto", schema = "unico", sequenceName = "sequencia_produto", allocationSize = 1, initialValue = 1)
@Table(name = "tbproduto", schema = "unico")
public class ModelProduto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_codigo_produto")
    @Column(name = "prdcodigo")
    private int codigo;
    
    @Column(name = "prdnome")
    private String nome;
    
    @Column(name = "prddescricao")
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
