package services;

import dao.DaoPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ModelPessoa;

/**
 * @author jessé
 */
@ManagedBean(name = "pessoaService")
@ApplicationScoped
public class PessoaService {
    
    
    public List<ModelPessoa> getAllRegistros() {
        DaoPessoa oDaoPessoa     = new DaoPessoa();
        List pessoas             = oDaoPessoa.getAll();
        List<ModelPessoa> oLista = new ArrayList<>();
        
        for(int i = 0; i < pessoas.size(); i ++) {
            oLista.add((ModelPessoa) pessoas.get(i));
        }
        
        return oLista;
    }
    
    public boolean salvar(ModelPessoa oPessoa) {
        DaoPessoa oDaoPessoa = new DaoPessoa();
        return oDaoPessoa.salvar(oPessoa);
    }
    
    public boolean exlcuir(ModelPessoa oPessoa) {
        DaoPessoa oDaoPessoa = new DaoPessoa();
        return oDaoPessoa.excluir(oPessoa);
    }
}
