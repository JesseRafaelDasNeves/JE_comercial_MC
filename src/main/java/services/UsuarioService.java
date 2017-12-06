package services;

import dao.DaoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ModelUsuario;

/**
 * @author jessé
 */
@ManagedBean(name = "usuarioService")
@ApplicationScoped
public class UsuarioService {
    
    
    public List<ModelUsuario> getAllRegistros() {
        DaoUsuario oDaoUsuario = new DaoUsuario();
        List usuarios            = oDaoUsuario.getAll();
        List<ModelUsuario> oLista = new ArrayList<>();
        
        for(int i = 0; i < usuarios.size(); i ++) {
            oLista.add((ModelUsuario) usuarios.get(i));
        }
        
        return oLista;
    }
    
    public boolean salvar(ModelUsuario oUsuario) {
        DaoUsuario oDaoUsuario = new DaoUsuario();
        return oDaoUsuario.salvar(oUsuario);
    }
    
    public boolean exlcuir(ModelUsuario oUsuario) {
        DaoUsuario oDaoUsuario = new DaoUsuario();
        return oDaoUsuario.excluir(oUsuario);
    }
}
