package model;

import java.util.ArrayList;

/**
 * @author jessé
 */
public class Lista {
    
    private int codigo;
    private String valor;

    public Lista() {
    }

    public Lista(int codigo, String valor) {
        this.codigo = codigo;
        this.valor = valor;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public static Lista getByCodigo(ArrayList<Lista> oLista, int codigo) {
        Lista oRetorno = null;
        for (Lista lista : oLista) {
            if(lista.getCodigo() == codigo) {
                oRetorno = lista;
                break;
            }
        }
        
        return oRetorno;
    }
}
