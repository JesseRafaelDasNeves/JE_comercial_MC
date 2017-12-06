package dao;

import java.util.ArrayList;
import javax.persistence.Query;
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

    @Override
    public Query getQueryAll() {
        return this.EntityManager.createQuery("select pessoa from ModelPessoa pessoa order by pessoa.codigo asc");
    }
}
