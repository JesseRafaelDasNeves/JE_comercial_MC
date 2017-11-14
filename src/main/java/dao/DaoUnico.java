package dao;

/**
 *
 * @author jessé
 */
public abstract class DaoUnico extends Dao {
    
    @Override
    protected String getPersistenceName() {
        return "UNICO_PU";
    }
}
