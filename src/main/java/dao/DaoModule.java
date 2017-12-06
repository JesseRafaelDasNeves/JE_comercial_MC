/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.persistence.Query;
import model.ModelModulo;

/**
 *
 * @author jessé
 */
public class DaoModule extends DaoUnico {
    
    public static ArrayList<ModelModulo> getAllModulo() {
        ArrayList<ModelModulo> oLista = new ArrayList<>();
        oLista.add(getModuloDefault());
        oLista.add(new ModelModulo(1001, "crm"     , "CRM"));
        oLista.add(new ModelModulo(1002, "vendas"  , "Vendas"));
        oLista.add(new ModelModulo(1003, "settings", "Gerenciar Sistema"));
        
        return oLista;
    }
    
    public static ModelModulo getModuloDefault() {
        return new ModelModulo(1000, "unico", "Único");
    }
    
    public static ModelModulo getModuloFromCodigo(int codigo) {
        ModelModulo oRetorno = null;
        ArrayList<ModelModulo> modulos = getAllModulo();
        for(int i = 0; i < modulos.size(); i++) {
            if(modulos.get(i).getCodigo() == codigo) {
                oRetorno = modulos.get(i);
                break;
            }
        }
        
        return oRetorno != null ? oRetorno : getModuloDefault();
    }

    @Override
    public Query getQueryAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
