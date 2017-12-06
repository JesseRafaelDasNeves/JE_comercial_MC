package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    @Column(name = "usutipo")
    private int tipo;
    
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
    
    public static String criptografaSenha(String senha) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
 
        return String.format("%32x", hash);
    }
}
