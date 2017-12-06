package dao;

import javax.persistence.Query;

/**
 * @author jessé
 */
public class DaoProduto extends DaoUnico {

    @Override
    public Query getQueryAll() {
        return this.EntityManager.createQuery("select produto from ModelProduto produto order by produto.codigo asc");
    }
    
}
