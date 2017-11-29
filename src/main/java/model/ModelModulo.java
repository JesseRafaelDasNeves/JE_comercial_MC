package model;

/**
 * @author jessé
 */
public class ModelModulo {
    
    private int codigo;
    private String nome;
    private String titulo;

    public ModelModulo() {
        this.codigo = 0;
        this.nome = "";
        this.titulo = "";
    }
    
    public ModelModulo(int codigo, String nome, String titulo) {
        this.codigo = codigo;
        this.nome = nome;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    
}
