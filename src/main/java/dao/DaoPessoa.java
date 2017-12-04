package dao;

import java.util.ArrayList;
import model.Lista;

/**
 *
 * @author jessé
 */
public class DaoPessoa extends DaoUnico {

    
    public static ArrayList<Lista> getTipoPessoa() {
        ArrayList<Lista> oLista = new ArrayList<>();
        oLista.add(new Lista(1, "Física"));
        oLista.add(new Lista(2, "Jurídica"));
        return oLista;
    }
}
