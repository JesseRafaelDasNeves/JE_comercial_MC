package dao;

import javax.persistence.Query;

/**
 * @author jessé
 */
public class DaoContato extends DaoCrm {

    @Override
    public Query getQueryAll() {
        return this.EntityManager.createQuery("SELECT contato FROM ModelContato contato ORDER BY contato.Pessoa.codigo");
    }
    
}
