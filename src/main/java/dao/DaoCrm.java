package dao;

/**
 * @author jessé
 */
abstract class DaoCrm extends Dao {

    @Override
    protected String getPersistenceName() {
        return "UNICO_PU";
    }
}
