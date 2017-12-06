package dao;

import javax.persistence.Query;

/**
 * @author jessé
 */
public class DaoFornecedor extends DaoUnico {

    @Override
    public Query getQueryAll() {
        return this.EntityManager.createQuery("select fornecedor from ModelFornecedor fornecedor order by fornecedor.codigo");
    }
}
