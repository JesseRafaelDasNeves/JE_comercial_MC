package dao;

import java.util.ArrayList;
import javax.persistence.Query;
import model.Lista;
import model.ModelUsuario;

/**
 * @author jessé
 */
public class DaoUsuario extends DaoUnico {

    @Override
    public Query getQueryAll() {
        return this.EntityManager.createQuery("SELECT usuario FROM ModelUsuario usuario ORDER BY usuario.Pessoa.codigo ");
    }
    
    public static ArrayList<Lista> getListaTipo() {
        ArrayList<Lista> oLista = new ArrayList<>();
        oLista.add(new Lista(1, "Administrador"));
        oLista.add(new Lista(2, "Vendedor"));
        return oLista;
    }
    
    public ModelUsuario getUsuarioAutenticado(ModelUsuario oUsuario) {
        Query oQuery = this.EntityManager.createQuery("SELECT usuario FROM ModelUsuario usuario WHERE usuario.login = :login AND usuario.senha = :senha");
        oQuery.setParameter("login", oUsuario.getLogin());
        oQuery.setParameter("senha", oUsuario.getSenha());
        
        try {
            return (ModelUsuario)oQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
