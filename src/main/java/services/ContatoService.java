package services;

import dao.DaoContato;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ModelContato;

/**
 * @author jessé
 */
@ManagedBean(name = "contatoService")
@ApplicationScoped
public class ContatoService {
    
    
    public List<ModelContato> getAllRegistros() {
        DaoContato oDaoContato = new DaoContato();
        List contatos            = oDaoContato.getAll();
        List<ModelContato> oLista = new ArrayList<>();
        
        for(int i = 0; i < contatos.size(); i ++) {
            oLista.add((ModelContato) contatos.get(i));
        }
        
        return oLista;
    }
    
    public boolean salvar(ModelContato oContato) {
        DaoContato oDaoContato = new DaoContato();
        return oDaoContato.salvar(oContato);
    }
    
    public boolean exlcuir(ModelContato oContato) {
        DaoContato oDaoContato = new DaoContato();
        return oDaoContato.excluir(oContato);
    }
}
