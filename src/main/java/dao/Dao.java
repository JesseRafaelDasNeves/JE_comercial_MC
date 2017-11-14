package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 *
 * @author Jesse Rafael
 */
public abstract class Dao {
    
    private EntityManager EntityManager;
    
    protected Dao() {
        this.EntityManager = this.getInstanceEntity();
    }
    
    protected abstract String getPersistenceName();
    
    private EntityManager getInstanceEntity() {
        if(this.EntityManager == null) {
            EntityManagerFactory oEntityFactory = Persistence.createEntityManagerFactory("UNICO_PU");
            this.EntityManager = oEntityFactory.createEntityManager();
        }
        
        return this.EntityManager;
    }
    
    public boolean salvar(Object oModel){
        this.begin();
        try {
            this.EntityManager.merge(oModel);
            this.commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            this.rollback();
            return false;
        }
    }
    
    public boolean excluir(Object oModel) {
        this.begin();
        try {
            this.EntityManager.remove(oModel);
            this.commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            this.rollback();
            return false;
        }
    }
    
    public void getAll() {
        FlushModeType teste = EntityManager.getFlushMode();
    }
    
    public void begin() {
        if(!this.EntityManager.getTransaction().isActive()) {
            this.EntityManager.getTransaction().begin();
        }
    }
    
    public void commit() {
        this.EntityManager.getTransaction().commit();
    }
    
    public void rollback() {
        this.EntityManager.getTransaction().rollback();
    }
}