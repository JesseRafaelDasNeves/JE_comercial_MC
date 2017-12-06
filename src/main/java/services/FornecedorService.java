package services;

import dao.DaoFornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ModelFornecedor;

/**
 * @author jessé
 */
@ManagedBean(name = "fornecedorService")
@ApplicationScoped
public class FornecedorService {
    
    
    public List<ModelFornecedor> getAllRegistros() {
        DaoFornecedor oDaoFornecedor = new DaoFornecedor();
        List fornecedores            = oDaoFornecedor.getAll();
        List<ModelFornecedor> oLista = new ArrayList<>();
        
        for(int i = 0; i < fornecedores.size(); i ++) {
            oLista.add((ModelFornecedor) fornecedores.get(i));
        }
        
        return oLista;
    }
    
    public boolean salvar(ModelFornecedor oFornecedor) {
        DaoFornecedor oDaoFornecedor = new DaoFornecedor();
        return oDaoFornecedor.salvar(oFornecedor);
    }
    
    public boolean exlcuir(ModelFornecedor oPessoa) {
        DaoFornecedor oDaoFornecedor = new DaoFornecedor();
        return oDaoFornecedor.excluir(oPessoa);
    }
}
