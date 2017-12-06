package dao;

import javax.persistence.Query;

/**
 * @author jessé
 */
public class DaoUsuario extends DaoUnico {

    @Override
    public Query getQueryAll() {
        return this.EntityManager.createQuery("SELECT usuario FROM ModelUsuario usuario ORDER BY usuario.Pessoa.codigo ");
    }
}
