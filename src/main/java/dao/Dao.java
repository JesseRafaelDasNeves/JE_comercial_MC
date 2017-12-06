package dao;

import controller.ControllerPadrao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jesse Rafael
 */
public abstract class Dao {
    
    protected EntityManager EntityManager;
    
    protected Dao() {
        this.EntityManager = this.getInstanceEntity();
    }
    
    protected abstract String getPersistenceName();
    
    public abstract Query getQueryAll();
    
    private EntityManager getInstanceEntity() {
        if(this.EntityManager == null) {
            EntityManagerFactory oEntityFactory = Persistence.createEntityManagerFactory(this.getPersistenceName());
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
            try {
                this.rollback();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
            return false;
        }
    }
    
    public boolean excluir(Object oModel) {
        this.begin();
        try {
            Object oRemove = oModel;
            if(!this.EntityManager.contains(oModel)) {
                oRemove = this.EntityManager.merge(oModel);
            }
            this.EntityManager.remove(oRemove);
            this.commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            try {
                this.rollback();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
            return false;
        }
    }
    
    public List getAll() {
        List oRetorno  = null;
        Query consulta = this.getQueryAll();
        try {
            oRetorno = consulta.getResultList();
        } catch (Exception e) {
            ControllerPadrao.addMessageErro("Erro ao buscar dados.");
        }
        
        return oRetorno;
    }
    
    
    public Object getFromId(Class classe, int id) {
        Object obj = null;
        try{
            obj = this.EntityManager.find(classe, id);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return obj;
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
